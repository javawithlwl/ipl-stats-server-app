package com.lwl.iplstats.api;

import com.lwl.iplstats.dto.PlayerDto;
import com.lwl.iplstats.dto.TeamBasicDto;
import com.lwl.iplstats.dto.TeamDto;
import com.lwl.iplstats.repo.TeamRepo;
import com.lwl.iplstats.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/team")
@RequiredArgsConstructor
public class TeamController {

  private final TeamService teamService;
  private final TeamRepo teamRepo;

  @PostMapping
  public ResponseEntity<TeamDto> addTeam(@RequestBody TeamDto teamDto) {
    TeamDto newTeam = teamService.addTeam(teamDto);
    return ResponseEntity.ok(newTeam);
  }
  @PostMapping("/all")
  public ResponseEntity<List<TeamDto>> addTeams(@RequestBody List<TeamDto> list) {
    List<TeamDto> newTeams = teamService.addTeams(list);
    return ResponseEntity.ok(newTeams);
  }

  @PutMapping("/{teamId}/player/{playerId}")
  public ResponseEntity<TeamDto> addPlayer(@PathVariable("teamId")String teamId,
                                           @PathVariable("playerId") String playerId){
    return  ResponseEntity.ok(teamService.addPlayer(teamId,playerId));
  }

  @PutMapping("/{teamId}/players/add")
  public ResponseEntity<TeamDto> addPlayer(@PathVariable("teamId") String teamId,@RequestBody List<PlayerDto> players){
    return  ResponseEntity.ok(null);
  }

  @GetMapping("/basic-details")
  public ResponseEntity<List<TeamBasicDto>> getTeamBasicDetails(){
    return ResponseEntity.ok(teamService.getTeamBasicDetails());
  }
}
