package com.example.fd.service;

import com.example.fd.entity.User;
import com.example.fd.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserByID(Long id){
        Optional<User> user = userRepository.findById(id);
        return userRepository.findById(id).get();
    }

    public User updateUserById(Long id, User user){
        User existingUser = userRepository.findById(id).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        userRepository.save(existingUser);
        return existingUser;
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

}
