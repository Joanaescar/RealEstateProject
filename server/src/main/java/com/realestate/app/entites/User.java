package com.realestate.app.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "user"
    )
    private List<House> houses;

}
