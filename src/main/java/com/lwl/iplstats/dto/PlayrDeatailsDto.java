package com.lwl.iplstats.dto;

import lombok.*;

import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@ToString
@Getter
@Setter
public class PlayrDeatailsDto {

    private UUID id;
    private String name;
    private String role;
    private String country;
    private double amount;
    private String label;

    public PlayrDeatailsDto(UUID id, String name, String role, String country, double amount, String label) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.country = country;
        this.amount = amount;
        this.label = label;
    }
}
