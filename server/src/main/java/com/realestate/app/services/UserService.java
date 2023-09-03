package com.realestate.app.services;

import com.realestate.app.entites.User;
import com.realestate.app.expectionHandler.UserExistsException;
import com.realestate.app.expectionHandler.UserNotFoundException;
import com.realestate.app.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User findById(int id){
       Optional<User> optUser = userRepository.findById(id);

       if(optUser.isEmpty()){
           throw new UserNotFoundException("Username not found");
       }

        return optUser.get();
    }

    public void createUser(User user) {

        User userTaken = userRepository.findByUsername(user.getUsername());

        if(user.getUsername().equals(userTaken.getUsername())) {
            throw new UserExistsException("Username is taken");
        }

        userRepository.save(user);
    }
}
