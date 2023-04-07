package com.lwl.iplstats.auth.service;

import com.lwl.iplstats.auth.domain.AppUser;
import com.lwl.iplstats.auth.repo.AppUserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserService implements UserDetailsService {

  private final AppUserRepo appUserRepo;
  private final PasswordEncoder passwordEncoder;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         log.info("Looking for user details :{}",username);
         return (UserDetails) appUserRepo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User details are not found"));
  }

  public String registerUser(AppUser appUser){
    appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
    appUser=appUserRepo.save(appUser);
    return "User saved with object :"+appUser.getId();
  }
}
