package com.lwl.iplstats.auth.controller;
import com.lwl.iplstats.auth.config.JwtUtil;
import com.lwl.iplstats.auth.domain.AppUser;
import com.lwl.iplstats.auth.dto.LoginRequest;
import com.lwl.iplstats.auth.dto.LoginResponse;
import com.lwl.iplstats.auth.service.AppUserService;
import lombok.RequiredArgsConstructor;
 import org.springframework.http.ResponseEntity;  
 import org.springframework.security.authentication.AuthenticationManager;  
 import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;  
 import org.springframework.security.core.userdetails.UserDetails;  
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestBody;  
 import org.springframework.web.bind.annotation.RequestMapping;  
 import org.springframework.web.bind.annotation.RestController;  
 @RestController  
 @RequestMapping("/api/auth")  
 @RequiredArgsConstructor  
 public class AuthController {  
    private final AuthenticationManager authenticationManager;  
    private final AppUserService userDetailsService;

    private final JwtUtil jwtUtil;
    @PostMapping("/login")  
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
       authenticationManager.authenticate(
         new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())  
       );  
     UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());  
     String jwtToken=jwtUtil.generateToken(userDetails);  
     return ResponseEntity.ok(new LoginResponse(jwtToken));  
    }
   @PostMapping("/register")
   public ResponseEntity<String> register(
       @RequestBody AppUser appUser
   ) {
     return ResponseEntity.ok(userDetailsService.registerUser(appUser));
   }
 }  