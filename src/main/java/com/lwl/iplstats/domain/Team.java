package com.lwl.iplstats.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "team_details")
@Getter
@Setter
public class Team extends  BaseEntity {
    @Id
    private UUID id;
    private String name;
    @Column(name = "label",unique = true)
    private String label;
    private String captain;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private List<Player> players = new ArrayList<>();
    @PrePersist
    public void onPersist(){
        this.id = UUID.randomUUID();
        super.onPersists();
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }
    public void removePlayer(Player player){
        this.players.remove(player);
    }
}
