package com.lwl.iplstats.api;

import com.lwl.iplstats.dto.*;
import com.lwl.iplstats.service.IplStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}/player-team-role/{role}")
    ResponseEntity<List<PlayerTeamRoleStats>> getPlayerTeamRoleStats(@PathVariable("id") UUID id, @PathVariable("role") String role) {
        List<PlayerTeamRoleStats> playerTeamRoleStats = iplStatsService.getPlayerTeamRoleStats(id,role);
        return ResponseEntity.ok(playerTeamRoleStats);
    }

    @GetMapping("/{id}/player-team-country/{country}")
    ResponseEntity<List<PlayerTeamRoleStats>> getPlayerTeamCountryStats(@PathVariable("id") UUID id, @PathVariable("country") String country) {
        List<PlayerTeamRoleStats> playerTeamCountryStats = iplStatsService.getPlayerTeamCountryStats(id, country);
        return ResponseEntity.ok(playerTeamCountryStats);
    }

    @GetMapping("/{id}/team")
    ResponseEntity<List<TeamBasicDto>> getTeamByTeamId(@PathVariable("id") UUID id) {
        List<TeamBasicDto> playerDtos = iplStatsService.getTeambyTeam(id);
        return ResponseEntity.ok(playerDtos);
    }
}
