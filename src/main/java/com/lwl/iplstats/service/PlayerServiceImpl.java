package com.lwl.iplstats.service;

import com.lwl.iplstats.domain.Player;
import com.lwl.iplstats.dto.CountryDto;
import com.lwl.iplstats.dto.PlayerDto;
import com.lwl.iplstats.dto.RoleDto;
import com.lwl.iplstats.repo.PlayerRepo;
import com.lwl.iplstats.util.Convertor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepo playerRepo;

    @Override
    public PlayerDto addPlayer(PlayerDto playerDto) {
        Player player = Convertor.toPlayer(playerDto);
        player = playerRepo.save(player);
        log.info("Player is created with id :{}", player.getId());
        playerDto = Convertor.toPlayerDto(player);
        return playerDto;
    }

    @Override
    public List<RoleDto> getRoles(UUID id) {
        return playerRepo.selectRoles(id);
    }

    @Override
    public List<CountryDto> getCountry(UUID id) {
        return playerRepo.selectCountry(id);
    }
}
