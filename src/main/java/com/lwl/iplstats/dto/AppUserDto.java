package com.lwl.iplstats.dto;

import com.lwl.iplstats.domain.Role;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class AppUserDto {
    private UUID id;
    private String username;
    private String email;
    private String password;
    private Role role;
    private String isDeleted;
}
