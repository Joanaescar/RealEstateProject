package com.realestate.app.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "house")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class House {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private float price;
    private int rooms;
    private int size;
    private HouseType type;
    private HouseState state;

    @ManyToOne
    private User user;
}
