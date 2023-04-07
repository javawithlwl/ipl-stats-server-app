package com.lwl.iplstats.auth.config;


import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;


public class UserDataRepo {
  private List<UserDetails> userDetails;
  public Optional<UserDetails> findByUsername(String username) {
      return userDetails.stream().filter(e->e.getUsername().equals(username)).findFirst();
  }
}
