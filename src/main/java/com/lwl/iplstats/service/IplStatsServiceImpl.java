package com.lwl.iplstats.service;

import com.lwl.iplstats.dto.*;
import com.lwl.iplstats.repo.IplStatsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class IplStatsServiceImpl implements IplStatsService {

    private final IplStatsRepo iplStatsRepo;

    @Override
    public List<TeamStatDto> getTeamStats() {
        return iplStatsRepo.selectTeamStats();
    }

    @Override
    public List<TeamRoleStatsDto> getTeamRoleStats(UUID id) {
        return iplStatsRepo.selectTeamRoleStats(id);
    }

    @Override
    public List<RoleStatsDto> getRoleStats() {
        return iplStatsRepo.selectRoleStats();
    }

    @Override
    public List<TeamCountryStatsDto> getTeamCountryStats(UUID id) {
        return iplStatsRepo.selectTeamCountryStats(id);
    }

    @Override
    public List<PlayerTeamRoleStats> getPlayerTeamRoleStats(UUID id, String role) {
        return iplStatsRepo.selectPlayerTeamRoleStats(id, role);
    }

    @Override
    public List<PlayerTeamRoleStats> getPlayerTeamCountryStats(UUID id, String country) {
        return iplStatsRepo.selectPlayerTeamCountryStats(id, country);
    }

    @Override
    public List<TeamBasicDto> getTeambyTeam(UUID id) {
        return iplStatsRepo.selectTeambyTeam(id);
    }
}
