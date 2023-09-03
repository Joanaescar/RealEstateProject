package com.realestate.app.services;

import com.realestate.app.entites.House;
import com.realestate.app.entites.HouseState;
import com.realestate.app.expectionHandler.HouseAlreadyAvailableException;
import com.realestate.app.expectionHandler.HouseNotFoundException;
import com.realestate.app.expectionHandler.HouseReservedByOtherException;
import com.realestate.app.expectionHandler.HouseReservedException;
import com.realestate.app.repositories.HouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class HouseService {

    private final HouseRepository houseRepository;
    private final UserService userService;

    public HouseService(HouseRepository houseRepository, UserService userService){
        this.houseRepository = houseRepository;
        this.userService = userService;
    }

    public House register(House house) {
        house.setState(HouseState.AVAILABLE);
        return this.houseRepository.save(house);
    }

    public List<House> listHouses() {
        List<House> houses = StreamSupport
                .stream(houseRepository.findAll().spliterator(), false)
                .toList();
        return houses;
    }


    public void reserve(int id, int userId) {
        Optional<House> optHouse = houseRepository.findById(id);

        if(optHouse.isEmpty()){
            throw new HouseNotFoundException("House not found");
        }

        House house = optHouse.get();

        if(house.getState() == HouseState.RESERVED){
            throw new HouseReservedException("House already reserved");
        }

        house.setState(HouseState.RESERVED);
        house.setUser(userService.findById(userId));

        houseRepository.save(house);
        System.out.println("House reserved " + house.getId());
    }

    public void unreserve(int id, int userId) {
        Optional<House> optHouse = houseRepository.findById(id); // vai procurar se existe uma casa com esse id

        if(optHouse.isEmpty()){ //verificar se a casa existe
            throw new HouseNotFoundException("House not found");
        }

        House house = optHouse.get(); // se existir vou depois trabalhar com esse objecto

        if(house.getState() == HouseState.AVAILABLE){
            throw new HouseAlreadyAvailableException("House is already available");
        }

        if(userId != house.getUser().getId()){
            throw new HouseReservedByOtherException("You don't have permission");
        }

        house.setState(HouseState.AVAILABLE);
        house.setUser(null);
        houseRepository.save(house);
        System.out.println("House unreserved " + house.getId());
    }

    public void delete(int idHouse){

        Optional<House> optHouse = houseRepository.findById(idHouse);

        if(optHouse.isEmpty()){ //verificar se a casa existe
            throw new HouseNotFoundException();
        }

        House house = optHouse.get();

        this.houseRepository.delete(house);
    }
}
