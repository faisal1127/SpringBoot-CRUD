package com.example.fd.service;

import com.example.fd.DTO.UserDTO;
import com.example.fd.Exceptions.EmailAlreadyExistsException;
import com.example.fd.Exceptions.ErrorDetails;
import com.example.fd.Exceptions.ResourceNotFoundException;
import com.example.fd.Mapper.AutoMapper;
import com.example.fd.Mapper.UserMapper;
import com.example.fd.entity.User;
import com.example.fd.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
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

        Optional<User> optionalUser = userRepository.findByEmail(userDTO.getEmail());
        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("User with given e-mail ID already exists");
        }
        User user = AutoMapper.MAPPER.mapToUser(userDTO);
        userRepository.save(user);
        return AutoMapper.MAPPER.mapToUserDTO(user);
    }

    public List<UserDTO> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users.stream().map(AutoMapper.MAPPER::mapToUserDTO).collect(Collectors.toUnmodifiableList());
    }

    public UserDTO getUserByID(Long id){
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "ID", String.valueOf(id))
        );
        return AutoMapper.MAPPER.mapToUserDTO(user);
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
