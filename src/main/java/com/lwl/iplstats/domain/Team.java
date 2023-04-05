package com.lwl.iplstats.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

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

    @OneToMany(mappedBy ="team",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Player> players = new HashSet<>();

    @PrePersist
    public void onPersist(){
        this.id = UUID.randomUUID();
        super.onPersists();
    }

    public void addPlayer(Player player){
        player.setTeam(this);
        this.players.add(player);
    }

    public void removePlayer(Player player){
        player.setTeam(null);
        this.players.remove(player);
    }
    public void addPlayers(List<Player> players){
        for(Player player:players){
            this.addPlayer(player);
        }
    }
    public void removePlayers(List<Player> players){
        for(Player player:players){
            this.removePlayer(player);
        }
    }
}
