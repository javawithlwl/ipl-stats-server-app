package com.lwl.iplstats.auth.repo;

import com.lwl.iplstats.auth.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AppUserRepo extends JpaRepository<AppUser, UUID> {
  Optional<AppUser> findByUsername(String username);
}
