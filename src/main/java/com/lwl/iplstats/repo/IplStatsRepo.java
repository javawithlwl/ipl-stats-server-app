package com.lwl.iplstats.repo;

import com.lwl.iplstats.domain.Team;
import com.lwl.iplstats.dto.PlayerDto;
import com.lwl.iplstats.dto.TeamStatDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface IplStatsRepo extends JpaRepository<Team, UUID> {

    @Query("select new com.lwl.iplstats.dto.TeamStatDto(t.id,t.label,sum(p.amount)) from Player p join p.team t group by t.id,t.label")
    public List<TeamStatDto> selectTeamStats();


}
