package com.realestate.app.repositories;

import com.realestate.app.entites.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
