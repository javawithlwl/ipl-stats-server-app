package com.lwl.iplstats.api;

import com.lwl.iplstats.dto.PlayerDto;
import com.lwl.iplstats.dto.TeamBasicDto;
import com.lwl.iplstats.dto.TeamDto;
import com.lwl.iplstats.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping
    public ResponseEntity<TeamDto> addTeam(@RequestBody TeamDto teamDto) {
        TeamDto newTeam = teamService.addTeam(teamDto);
        return ResponseEntity.ok(newTeam);
    }

    @PostMapping("/add-all")
    public ResponseEntity<List<TeamDto>> addTeams(@RequestBody List<TeamDto> list) {
        List<TeamDto> newTeams = teamService.addTeams(list);
        return ResponseEntity.ok(newTeams);
    }

    @PutMapping("/{teamId}/player/{playerId}")
    public ResponseEntity<TeamDto> addPlayer(@PathVariable("teamId") String teamId,
                                             @PathVariable("playerId") String playerId) {
        return ResponseEntity.ok(teamService.addPlayer(teamId, playerId));
    }

    @PutMapping("/{teamId}/players/add-all")
    public ResponseEntity<TeamDto> addPlayer(@PathVariable("teamId") String teamId, @RequestBody List<PlayerDto> players) {
        TeamDto teamdto = teamService.addPlayers(teamId, players);
        return ResponseEntity.ok(teamdto);
    }

    @GetMapping("/basic-details")
    public ResponseEntity<List<TeamBasicDto>> getTeamBasicDetails() {
        return ResponseEntity.ok(teamService.getTeamBasicDetails());
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadTeamWithPlayer(@RequestParam("file") MultipartFile file) {
        String message = teamService.uploadFile(file);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/download")
    public ResponseEntity<String> downloadTeanDto() {
        String message = teamService.downloadData();
        return ResponseEntity.ok(message);
    }

}
