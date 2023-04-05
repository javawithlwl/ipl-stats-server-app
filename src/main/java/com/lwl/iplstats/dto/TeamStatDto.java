package com.lwl.iplstats.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@ToString

public class TeamStatDto {
    private UUID id;
    private String label;
    private double totalAmount;

    public TeamStatDto(UUID id, String label, double totalAmount) {
        this.id = id;
        this.label = label;
        this.totalAmount = totalAmount;
    }
}
