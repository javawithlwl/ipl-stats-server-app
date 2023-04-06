package com.lwl.iplstats.api;

import com.lwl.iplstats.dto.TeamRoleStatsDto;
import com.lwl.iplstats.dto.TeamStatDto;
import com.lwl.iplstats.service.IplStatsService;
import lombok.RequiredArgsConstructor;
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
    ResponseEntity<List<TeamStatDto>> getTeamStats(){
        List<TeamStatDto> teamStatDtos = iplStatsService.getTeamStats();
        return ResponseEntity.ok(teamStatDtos);
    }


    @GetMapping("/team-role-stats/{id}")
    ResponseEntity<List<TeamRoleStatsDto>> getTeamRoleStats(@PathVariable("id") UUID id){
        List<TeamRoleStatsDto> teamRoleStatsDtos = iplStatsService.getTeamRoleStats(id);
        return ResponseEntity.ok(teamRoleStatsDtos);
    }
}
