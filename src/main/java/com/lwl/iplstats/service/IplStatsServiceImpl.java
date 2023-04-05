package com.lwl.iplstats.service;

import com.lwl.iplstats.dto.PlayerDto;
import com.lwl.iplstats.dto.TeamStatDto;
import com.lwl.iplstats.repo.IplStatsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class IplStatsServiceImpl implements IplStatsService{

    private final IplStatsRepo iplStatsRepo;
    @Override
    public List<TeamStatDto> getTeamStats() {
        return iplStatsRepo.selectTeamStats();
    }
}
