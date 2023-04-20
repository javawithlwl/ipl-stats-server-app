package com.lwl.iplstats.dto;

import lombok.*;

import java.util.UUID;

@Getter
@NoArgsConstructor
@Setter
@ToString
@Builder
public class PlayerTeamCountryDto {
    private UUID id;
    private String country;

    public PlayerTeamCountryDto(UUID id, String country) {
        this.id = id;
        this.country = country;
    }
}
