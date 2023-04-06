package com.lwl.iplstats.service;

import com.lwl.iplstats.dto.*;

import java.util.List;
import java.util.UUID;

public interface IplStatsService {

    List<TeamStatDto> getTeamStats();

    List<TeamRoleStatsDto> getTeamRoleStats(UUID id);

    List<RoleStatsDto> getRoleStats();

    List<TeamCountryStatsDto> getTeamCountryStats(UUID id);

    List<PlayerTeamRoleStats> getPlayerTeamRoleStats(UUID id, String role);

    List<PlayerTeamRoleStats> getPlayerTeamCountryStats(UUID id, String country);

}
