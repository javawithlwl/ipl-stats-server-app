package com.lwl.iplstats.service;

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
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        ()->new IllegalArgumentException("Team details are not found")
    );
    Player player = playerRepo.findById(pId).orElseThrow(()->new IllegalArgumentException("Player details are not found"));
    team.addPlayer(player);
    team=teamRepo.save(team);
    TeamDto teamDto = Convertor.toTeamDto(team);
    return teamDto;
  }
  @Override
  public List<TeamDto> addTeams(List<TeamDto> list) {
    List<Team> teamList = list.stream().map(Convertor::toTeam).collect(Collectors.toList());
    teamList = teamRepo.saveAll(teamList);
    log.info("{} teams are added ",teamList.size());
    List<TeamDto> teamListDto = teamList.stream().map(Convertor::toTeamDto).collect(Collectors.toList());
    return teamListDto;
  }

  @Override
  public TeamDto addPlayers(String teamId, List<PlayerDto> playersDto) {
    List<Player> playerList = playersDto.stream().map(Convertor::toPlayer).collect(Collectors.toList());
    UUID tId = UUID.fromString(teamId);
    Team team = teamRepo.findById(tId).orElseThrow(
            ()->new IllegalArgumentException("Team details are not found")
    );
    for (Player player:playerList){
      team.addPlayer(player);
      team=teamRepo.save(team);
    }
    log.info("{} tplayers are added to team with id {}",playerList.size(), teamId);
    Team teamdto = teamRepo.getReferenceById(tId);
    TeamDto teamDto = Convertor.toTeamDto(teamdto);
    return teamDto;

  }

  @Override
  public List<TeamBasicDto> getTeamBasicDetails() {
    List<Team> teams = teamRepo.findAll();
    List<TeamBasicDto> teamBasicDtos = teams.stream().map(ele -> {
      TeamBasicDto obj =
          TeamBasicDto.builder()
              .id(ele.getId())
              .name(ele.getName())
              .label(ele.getLabel())
              .captain(ele.getCaptain()).build();
      return obj;
    }).collect(Collectors.toList());
    return teamBasicDtos;
  }
}
