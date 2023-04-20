package com.lwl.iplstats.api;

import com.lwl.iplstats.dto.CountryDto;
import com.lwl.iplstats.dto.PlayerDto;
import com.lwl.iplstats.dto.RoleDto;
import com.lwl.iplstats.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{id}/roles")
    public ResponseEntity<List<RoleDto>> getRoles(@PathVariable("id") UUID id) {
        List<RoleDto> roles = playerService.getRoles(id);
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}/country")
    public ResponseEntity<List<CountryDto>> getCountry(@PathVariable("id") UUID id) {
        List<CountryDto> roles = playerService.getCountry(id);
        return ResponseEntity.ok(roles);
    }
}
