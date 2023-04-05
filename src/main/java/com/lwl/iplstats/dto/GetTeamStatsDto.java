package com.lwl.iplstats.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class GetTeamStatsDto {

    private String label;
    private double totalAmount;
}
