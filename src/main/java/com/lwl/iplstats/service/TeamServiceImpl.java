package com.lwl.iplstats.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lwl.iplstats.domain.Player;
import com.lwl.iplstats.domain.Team;
import com.lwl.iplstats.dto.PlayerDto;
import com.lwl.iplstats.dto.TeamBasicDto;
import com.lwl.iplstats.dto.TeamDto;
import com.lwl.iplstats.repo.PlayerRepo;
import com.lwl.iplstats.repo.TeamRepo;
import com.lwl.iplstats.util.Convertor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamServiceImpl implements TeamService {

    private final TeamRepo teamRepo;
    private final PlayerRepo playerRepo;

    @Override
    public TeamDto addTeam(TeamDto teamDto) {
        Team team = Convertor.toTeam(teamDto);
        Team newTeam = teamRepo.save(team);
        log.info("Team is created with id :{}", newTeam.getId());
        teamDto = Convertor.toTeamDto(newTeam);
        return teamDto;
    }

    @Transactional
    @Override
    public TeamDto addPlayer(String teamId, String playerId) {
        UUID tId = UUID.fromString(teamId);
        UUID pId = UUID.fromString(playerId);
        Team team = teamRepo.findById(tId).orElseThrow(
                () -> new IllegalArgumentException("Team details are not found")
        );
        Player player = playerRepo.findById(pId).orElseThrow(() -> new IllegalArgumentException("Player details are not found"));
        team.addPlayer(player);
        team = teamRepo.save(team);
        return Convertor.toTeamDto(team);
    }

    @Override
    public List<TeamDto> addTeams(List<TeamDto> list) {
        List<Team> teamList = list.stream().map(Convertor::toTeam).toList();
        teamList = teamRepo.saveAll(teamList);
        log.info("{} teams are added ", teamList.size());
        return teamList.stream().map(Convertor::toTeamDto).toList();
    }

    @Override
    public TeamDto addPlayers(String teamId, List<PlayerDto> playersDto) {
        UUID tId = UUID.fromString(teamId);
        Team team = teamRepo.findById(tId).orElseThrow(
                () -> new IllegalArgumentException("Team details are not found")
        );
        List<Player> playerList = playersDto.stream().map(Convertor::toPlayer).toList();
        team.addPlayers(playerList);
        team = teamRepo.save(team);
        log.info("{} players are added to team with id {}", playerList.size(), team.getId());
        Team teamdto = teamRepo.getReferenceById(tId);
        return Convertor.toTeamDto(teamdto);

    }

    @Override
    public List<TeamBasicDto> getTeamBasicDetails() {
        List<Team> teams = teamRepo.findAll();
        return teams.stream().map(ele ->
                TeamBasicDto.builder()
                        .id(ele.getId())
                        .name(ele.getName())
                        .label(ele.getLabel())
                        .captain(ele.getCaptain()).build()

        ).toList();
    }

    @Override
    public String uploadFile(MultipartFile multipartFile) {

        CompletableFuture.runAsync(() -> {
            try {
                log.info("Creating Temp Directory");
                String tmpdir = System.getProperty("java.io.tmpdir");
                File newFile = new File(tmpdir + "/team_player.json");
                log.info("Temp file is create at :{}", newFile);
                multipartFile.transferTo(newFile);
                ObjectMapper objectMapper = new ObjectMapper();
                List<TeamDto> teamDtoList = objectMapper.readValue(newFile, new TypeReference<List<TeamDto>>() {
                });
                List<Team> teamList = teamDtoList.stream().map(Convertor::toTeam).toList();
                log.info("Added {} team details ", teamList.size());
                teamList = teamRepo.saveAll(teamList);
            } catch (Exception e) {
                log.error("While uploading file content :" + e);
            }
        });
        return "File uploaded successfully";
    }
}
