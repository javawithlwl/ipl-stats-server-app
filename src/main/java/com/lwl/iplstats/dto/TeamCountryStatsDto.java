package com.lwl.iplstats.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Builder
public class TeamCountryStatsDto {
    private String country;
    private double totalAmount;
    private String label;

    public TeamCountryStatsDto(String country, double totalAmount, String label) {
        this.country = country;
        this.totalAmount = totalAmount;
        this.label = label;
    }

}
