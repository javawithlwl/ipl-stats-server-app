package com.lwl.iplstats.repo;

import com.lwl.iplstats.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeamRepo extends JpaRepository<Team, UUID> {
}
