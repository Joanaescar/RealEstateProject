package com.realestate.app.controllers;

import com.realestate.app.DTO.HouseDTO;
import com.realestate.app.DTO.UserDTO;
import com.realestate.app.entites.House;
import com.realestate.app.entites.User;
import com.realestate.app.services.HouseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/house")
public class HouseController {

    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping()
    public List<HouseDTO> listHouse(){
        List<House> houses = houseService.listHouses();
        List<HouseDTO> housesDto = houses.stream()
                .map(HouseDTO::fromModel)
                .collect(Collectors.toList());
        return housesDto;
    }

    @CrossOrigin(origins = "*")
    @PostMapping()
    public HouseDTO createHouse(@RequestBody HouseDTO houseDto) {
       House house = houseService.register(HouseDTO.fromDto(houseDto));
       return HouseDTO.fromModel(house);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public void deleteHouse(@PathVariable int id){
        houseService.delete(id);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}/reserve")
    public void reserve(@PathVariable int id, @RequestBody UserDTO userDTO){
        User user = UserDTO.fromDto(userDTO);
        houseService.reserve(id, user.getId());
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}/unreserve")
    public void unreserve(@PathVariable int id, @RequestBody UserDTO userDTO){
        User user = UserDTO.fromDto(userDTO);
        houseService.unreserve(id, user.getId());
    }



}

