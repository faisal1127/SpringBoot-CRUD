package com.example.fd.Mapper;

import com.example.fd.DTO.UserDTO;
import com.example.fd.entity.User;

public class UserMapper {
    public static UserDTO converttoUserDTO(User user){
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }
    public static User converttoUser(UserDTO userDTO){
        return new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail()
        );
    }

}
