package com.lwl.iplstats.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString

public class TeamCountryStatsDto {

    private String country;
    private double totalAmount;

    public TeamCountryStatsDto(String country, double totalAmount) {
        this.country = country;
        this.totalAmount = totalAmount;
    }
}
