package com.lwl.iplstats.repo;

import com.lwl.iplstats.domain.Team;
import com.lwl.iplstats.dto.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

public interface IplStatsRepo extends JpaRepository<Team, UUID> {

    @Query("select new com.lwl.iplstats.dto.TeamStatDto(t.id,t.label,sum(p.amount)) from Player p join p.team t group by t.id,t.label")
    public List<TeamStatDto> selectTeamStats();

    @Query("select new com.lwl.iplstats.dto.TeamRoleStatsDto(role,sum(amount),t.label)  from Player p join p.team t where t.id=:id group by p.role,t.label")
    public List<TeamRoleStatsDto> selectTeamRoleStats(@Param("id") UUID id);

    @Query("select new com.lwl.iplstats.dto.RoleStatsDto(p.role,sum(p.amount)) from Player p group by p.role")
    public List<RoleStatsDto> selectRoleStats();

    @Query("select new com.lwl.iplstats.dto.TeamCountryStatsDto(p.country,sum(amount) as totalAmount) from Player p join p.team t where t.id=:id group by p.country")
    public List<TeamCountryStatsDto> selectTeamCountryStats(@Param("id") UUID id);

    @Query("select new com.lwl.iplstats.dto.PlayerTeamRoleStats(p.id,p.name,p.country,p.role,p.amount,t.label,t.id as team_id) from Player p join p.team t where t.id=:id and lower(p.role) =lower(:role)")
    public List<PlayerTeamRoleStats> selectPlayerTeamRoleStats(@RequestParam("id") UUID id, @RequestParam("p.role") String role);

    @Query("select new com.lwl.iplstats.dto.PlayerTeamRoleStats(p.id,p.name,p.country,p.role,p.amount,t.label,t.id as team_id) from Player p join p.team t where t.id=:id and lower(p.country) =lower(:country)")
    public List<PlayerTeamRoleStats> selectPlayerTeamCountryStats(@RequestParam("id") UUID id, @RequestParam("p.role") String country);


}
