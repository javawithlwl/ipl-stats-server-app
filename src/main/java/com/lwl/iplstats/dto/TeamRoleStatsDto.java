package com.lwl.iplstats.dto;

import lombok.*;
@Getter
@Setter
@Builder
@NoArgsConstructor
@ToString
public class TeamRoleStatsDto {
    private String role;
    private double totalAmount;

    public TeamRoleStatsDto(String role, double totalAmount) {
        this.role = role;
        this.totalAmount = totalAmount;
    }
}
