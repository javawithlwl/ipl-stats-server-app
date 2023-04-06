package com.lwl.iplstats.service;

import com.lwl.iplstats.dto.PlayerDto;
import com.lwl.iplstats.dto.TeamBasicDto;
import com.lwl.iplstats.dto.TeamDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TeamService {

    TeamDto addTeam(TeamDto teamDto);

    TeamDto addPlayer(String teamId, String playerId);

    List<TeamDto> addTeams(List<TeamDto> list);

    TeamDto addPlayers(String teamId, List<PlayerDto> playersDto);

    List<TeamBasicDto> getTeamBasicDetails();

    String uploadFile(MultipartFile file);
}
