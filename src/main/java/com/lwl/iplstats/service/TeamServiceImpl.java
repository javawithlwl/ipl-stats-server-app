package com.lwl.iplstats.service;

import com.lwl.iplstats.domain.Player;
import com.lwl.iplstats.domain.Team;
import com.lwl.iplstats.dto.TeamDto;
import com.lwl.iplstats.repo.PlayerRepo;
import com.lwl.iplstats.repo.TeamRepo;
import com.lwl.iplstats.util.Convertor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
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
    team.getPlayers().add(player);
    team=teamRepo.save(team);
    player.setTeam(team);
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
}
