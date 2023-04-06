package com.lwl.iplstats.repo;

import com.lwl.iplstats.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface AppUserRepo extends JpaRepository<AppUser, UUID> {


//    @Query("insert into AppUser(username,email,password,role,isDeleted) values(?,?,?,?,?)")
//    public AppUser createUser(AppUser appUser);
//
//    @Query("update AppUser set isDeleted = true")
//    public AppUser deleteUser(AppUser appUser);




}
