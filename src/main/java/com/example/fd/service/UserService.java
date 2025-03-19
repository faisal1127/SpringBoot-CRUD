package com.example.fd.service;

import com.example.fd.DTO.UserDTO;
import com.example.fd.Mapper.AutoMapper;
import com.example.fd.Mapper.UserMapper;
import com.example.fd.entity.User;
import com.example.fd.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO createUser(UserDTO userDTO){

        User user = AutoMapper.MAPPER.mapToUser(userDTO);
        userRepository.save(user);
        return AutoMapper.MAPPER.mapToUserDTO(user);
    }

    public List<UserDTO> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users.stream().map(AutoMapper.MAPPER::mapToUserDTO).collect(Collectors.toUnmodifiableList());
    }

    public UserDTO getUserByID(Long id){
        Optional<User> user = userRepository.findById(id);
        return AutoMapper.MAPPER.mapToUserDTO(userRepository.findById(id).get());
    }

    public UserDTO updateUserById(Long id, UserDTO userDTO){
        User existingUser = userRepository.findById(id).get();
        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setEmail(userDTO.getEmail());
        userRepository.save(existingUser);
        return AutoMapper.MAPPER.mapToUserDTO(existingUser);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

}
