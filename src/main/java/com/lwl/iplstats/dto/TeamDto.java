package com.lwl.iplstats.dto;

import com.lwl.iplstats.domain.Player;
import com.lwl.iplstats.domain.Team;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDto {
  private UUID id;
  private String name;
  private String label;
  private String captain;
  private List<Player> players = new ArrayList<>();


 }
