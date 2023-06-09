package com.lwl.iplstats.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {
  private UUID id;
  private String name;
  private String role;
  private String country;
  private double amount;
}
