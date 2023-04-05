package com.lwl.iplstats.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TeamBasicDto {

    private UUID id;
    private String label;
    private String name;
    private String captain;

}
