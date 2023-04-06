package com.lwl.iplstats.service;
import com.lwl.iplstats.dto.TeamRoleStatsDto;
import com.lwl.iplstats.dto.TeamStatDto;
import java.util.List;
import java.util.UUID;

public interface IplStatsService {

    List<TeamStatDto> getTeamStats();

    List<TeamRoleStatsDto> getTeamRoleStats(UUID id);
}
