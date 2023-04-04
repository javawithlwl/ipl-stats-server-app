package com.lwl.iplstats.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="player")
public class Player extends BaseEntity {
  @Id
  private UUID id;
  private String name;
  private String role;
  private String country;
  private double amount;
  @ManyToOne
  private Team team;
  @PrePersist
  public void onPersist(){
    this.id = UUID.randomUUID();
    super.onPersists();
  }
}
