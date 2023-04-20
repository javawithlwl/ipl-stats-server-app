package com.lwl.iplstats.service;

import com.lwl.iplstats.dto.CountryDto;
import com.lwl.iplstats.dto.PlayerDto;
import com.lwl.iplstats.dto.RoleDto;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PlayerService {

    public PlayerDto addPlayer(PlayerDto playerDto);

    List<RoleDto> getRoles(@Param("id") UUID id);

    List<CountryDto> getCountry(@Param("id") UUID id);

}
