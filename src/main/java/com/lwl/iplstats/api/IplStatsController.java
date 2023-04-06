package com.lwl.iplstats.api;

import com.lwl.iplstats.dto.*;
import com.lwl.iplstats.service.IplStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/stats")
@RequiredArgsConstructor
public class IplStatsController {

    private final IplStatsService iplStatsService;

    @GetMapping("/team-stats")
    ResponseEntity<List<TeamStatDto>> getTeamStats() {
        List<TeamStatDto> teamStatDtos = iplStatsService.getTeamStats();
        return ResponseEntity.ok(teamStatDtos);
    }


    @GetMapping("/team-role-stats/{id}")
    ResponseEntity<List<TeamRoleStatsDto>> getTeamRoleStats(@PathVariable("id") UUID id) {
        List<TeamRoleStatsDto> teamRoleStatsDtos = iplStatsService.getTeamRoleStats(id);
        return ResponseEntity.ok(teamRoleStatsDtos);
    }

    @GetMapping("/role-stats")
    ResponseEntity<List<RoleStatsDto>> getRoleStats() {
        List<RoleStatsDto> roleStatsDtos = iplStatsService.getRoleStats();
        return ResponseEntity.ok(roleStatsDtos);
    }

    @GetMapping("/team-country-stats/{id}")
    ResponseEntity<List<TeamCountryStatsDto>> getTeamCountryStats(@PathVariable("id") UUID id) {
        List<TeamCountryStatsDto> teamCountryStatsDtos = iplStatsService.getTeamCountryStats(id);
        return ResponseEntity.ok(teamCountryStatsDtos);
    }

    @GetMapping("/player-team-role")
    ResponseEntity<List<PlayerTeamRoleStats>> getPlayerTeamRoleStats(@Param("id") UUID id, @Param("role") String role) {
        List<PlayerTeamRoleStats> playerTeamRoleStats = iplStatsService.getPlayerTeamRoleStats(id, role);
        return ResponseEntity.ok(playerTeamRoleStats);
    }

    @GetMapping("/player-team-country")
    ResponseEntity<List<PlayerTeamRoleStats>> getPlayerTeamCountryStats(@Param("id") UUID id, @Param("role") String country) {
        List<PlayerTeamRoleStats> playerTeamCountryStats = iplStatsService.getPlayerTeamCountryStats(id, country);
        return ResponseEntity.ok(playerTeamCountryStats);
    }
}
