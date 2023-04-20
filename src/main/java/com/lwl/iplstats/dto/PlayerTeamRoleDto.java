package com.lwl.iplstats.dto;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
public class PlayerTeamRoleDto {
    private UUID id;
    private String role;

    public PlayerTeamRoleDto(UUID id, String role) {
        this.id = id;
        this.role = role;
    }
}
