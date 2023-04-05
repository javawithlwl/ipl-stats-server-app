package com.lwl.iplstats.service;

import com.lwl.iplstats.dto.PlayerDto;

import java.util.List;

public interface IplStatsService {

    List<PlayerDto> getTeamStats();
}
