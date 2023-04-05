package com.lwl.iplstats.api;

import com.lwl.iplstats.dto.PlayerDto;
import com.lwl.iplstats.service.IplStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/iplStats")
@RequiredArgsConstructor
public class IplStatsController {

    private final IplStatsService iplStatsService;
    @GetMapping("/team-stats")
    ResponseEntity<List<PlayerDto>> getTeamStats(){
        List<PlayerDto> playerDto = iplStatsService.getTeamStats();
        return ResponseEntity.ok(playerDto);
    }
}
