package com.realestate.app.DTO;

import com.realestate.app.entites.House;
import com.realestate.app.entites.HouseState;
import com.realestate.app.entites.HouseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HouseDTO {
    private int id;
    private float price;
    private int rooms;
    private int size;
    private HouseType type;
    private HouseState state;

    public static HouseDTO fromModel(House house){
        HouseDTO houseDTO = HouseDTO.builder()
                .id(house.getId())
                .price(house.getPrice())
                .rooms(house.getRooms())
                .size(house.getSize())
                .type(house.getType())
                .state(house.getState())
                .build();
        return houseDTO;
    }

    public static House fromDto(HouseDTO houseDto){
        House house = House.builder()
                .id(houseDto.getId())
                .price(houseDto.getPrice())
                .rooms(houseDto.getRooms())
                .size(houseDto.getSize())
                .type(houseDto.getType())
                .state(houseDto.getState())
                .build();
        return house;
    }
}
