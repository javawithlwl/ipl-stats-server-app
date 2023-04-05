package com.lwl.iplstats.util;

import com.lwl.iplstats.domain.Player;
import com.lwl.iplstats.domain.Team;
import com.lwl.iplstats.dto.PlayerDto;
import com.lwl.iplstats.dto.TeamDto;

public class Convertor {
  public static Team toTeam(TeamDto teamDto){
    Team team = new Team();
    team.setName(teamDto.getName());
    team.setId(teamDto.getId());
    team.setLabel(teamDto.getLabel());
    team.setCaptain(teamDto.getCaptain());
    team.getPlayers().addAll(teamDto.getPlayers());
    return team;
  }
  public static TeamDto toTeamDto(Team team){
    TeamDto teamDto = new TeamDto();
    teamDto.setName(team.getName());
    teamDto.setId(team.getId());
    teamDto.setLabel(team.getLabel());
    teamDto.setCaptain(team.getCaptain());
    teamDto.getPlayers().addAll(team.getPlayers());
    return teamDto;
  }

  public static Player toPlayer(PlayerDto playerDto){
    Player player = new Player();
    player.setName(playerDto.getName());
    player.setId(playerDto.getId());
    player.setAmount(playerDto.getAmount());
    player.setRole(playerDto.getRole());
    player.setCountry(playerDto.getCountry());
    player.setTeam(player.getTeam());
    return player;
  }
  public static PlayerDto toPlayerDto(Player player){
    PlayerDto playerDto = new PlayerDto();
    playerDto.setName(player.getName());
    playerDto.setId(player.getId());
    playerDto.setAmount(player.getAmount());
    playerDto.setRole(player.getRole());
    playerDto.setCountry(player.getCountry());
    playerDto.setTeam(player.getTeam());
    return playerDto;
  }
}
