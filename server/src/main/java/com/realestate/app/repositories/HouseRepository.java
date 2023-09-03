package com.realestate.app.repositories;

import com.realestate.app.entites.House;
import com.realestate.app.entites.HouseState;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HouseRepository extends CrudRepository<House, Integer> {
    List<House> findByState(HouseState state); //ele vai encontrar a casa pelo state colocado no argumento, é o motor da db que tem a responsabilidade de filtrar

}
