package com.lwl.iplstats.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name="player")
@Getter
@Setter
@Data
public class Player extends BaseEntity {
  @Id
  private UUID id;
  private String name;
  private String role;
  private String country;
  private double amount;
  @ManyToOne
  @JoinColumn(name = "team_id")
  @JsonIgnore
  private Team team;
  @PrePersist
  public void onPersist(){
    this.id = UUID.randomUUID();
    super.onPersists();
  }
}
