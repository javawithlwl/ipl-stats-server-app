package com.lwl.iplstats.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
public class RoleStatsDto {

    private String role;
    private double totalAmount;

    public RoleStatsDto(String role, double totalAmount) {
        this.role = role;
        this.totalAmount = totalAmount;
    }
}
