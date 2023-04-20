package com.lwl.iplstats.dto;

import lombok.Data;

@Data
public class CountryDto {
    private String country;

    public CountryDto(String country) {
        this.country = country;
    }
}
