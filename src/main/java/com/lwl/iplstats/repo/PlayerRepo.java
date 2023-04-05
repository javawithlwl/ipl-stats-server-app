package com.lwl.iplstats.repo;

import com.lwl.iplstats.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlayerRepo extends JpaRepository<Player, UUID> {

}
