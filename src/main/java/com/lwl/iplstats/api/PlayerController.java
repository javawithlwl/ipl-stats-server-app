package com.lwl.iplstats.api;

import com.lwl.iplstats.dto.PlayerDto;
import com.lwl.iplstats.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/player")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping
    public ResponseEntity<PlayerDto> addTeam(@RequestBody PlayerDto playerDto) {
        PlayerDto newPlayer = playerService.addPlayer(playerDto);
        return ResponseEntity.ok(newPlayer);
    }


}
