package com.realestate.app.DTO;

import com.realestate.app.entites.House;
import com.realestate.app.entites.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private int id;
    private String username;
    public static UserDTO fromModel(User user){
        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
        return userDTO;
    }

    public static User fromDto(UserDTO userDto){
        User user = User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .build();
        return user;
    }

}
