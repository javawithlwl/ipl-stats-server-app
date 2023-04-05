package com.lwl.iplstats.service;
import com.lwl.iplstats.dto.TeamStatDto;
import java.util.List;

public interface IplStatsService {

    List<TeamStatDto> getTeamStats();
}
