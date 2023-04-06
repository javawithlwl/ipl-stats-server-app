package com.lwl.iplstats.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder

public class PlayerTeamRoleStats {

    private UUID id;
    private String name;
    private String country;
    private String role;
    private double amount;
    private String label;
    private UUID team_id;

    public PlayerTeamRoleStats(UUID id, String name, String country, String role, double amount, String label, UUID team_id) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.role = role;
        this.amount = amount;
        this.label = label;
        this.team_id = team_id;
    }
}
