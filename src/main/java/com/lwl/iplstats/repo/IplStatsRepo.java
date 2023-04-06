package com.lwl.iplstats.repo;

import com.lwl.iplstats.domain.Team;
import com.lwl.iplstats.dto.TeamRoleStatsDto;
import com.lwl.iplstats.dto.TeamStatDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface IplStatsRepo extends JpaRepository<Team, UUID> {

    @Query("select new com.lwl.iplstats.dto.TeamStatDto(t.id,t.label,sum(p.amount)) from Player p join p.team t group by t.id,t.label")
    public List<TeamStatDto> selectTeamStats();


    @Query("select new com.lwl.iplstats.dto.TeamRoleStatsDto(role,sum(amount),t.label)  from Player p join p.team t where t.id=:id group by p.role,t.label")
    public List<TeamRoleStatsDto> selectTeamRoleStats(@Param("id") UUID id);
}
