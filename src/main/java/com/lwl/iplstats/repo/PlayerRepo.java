package com.lwl.iplstats.repo;

import com.lwl.iplstats.domain.Player;
import com.lwl.iplstats.dto.CountryDto;
import com.lwl.iplstats.dto.RoleDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PlayerRepo extends JpaRepository<Player, UUID> {

    @Query("select new com.lwl.iplstats.dto.RoleDto(p.role) from Player p join p.team t where t.id=:id group by p.role")
    public List<RoleDto> selectRoles(@Param("id") UUID id);

    @Query("select new com.lwl.iplstats.dto.CountryDto(p.country) from Player p join p.team t where t.id=:id group by p.country")
    public List<CountryDto> selectCountry(@Param("id") UUID id);

}
