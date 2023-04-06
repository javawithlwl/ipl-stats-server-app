package com.lwl.iplstats.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@ToString
@Entity
@Table(name = "user_details")
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AppUser extends BaseEntity {

    @Id
    private UUID id;
    private String username;
    @Column(name = "email", unique = true)
    private String email;
    private String password;
    private Role role;
    private String isDeleted;

    public void onPersist() {
        this.id = UUID.randomUUID();
        super.onPersists();
    }
}
