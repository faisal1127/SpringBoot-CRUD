package com.example.fd.controller;

import com.example.fd.DTO.UserDTO;
import com.example.fd.Exceptions.ErrorDetails;
import com.example.fd.Exceptions.ResourceNotFoundException;
import com.example.fd.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@Tag(
        name = "CRUD operations using REST API",
        description = "CRUD operations using REST API (create, get, update, delete)"
)
@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(
            summary = "Create a User",
            description = "It creates a user"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS CREATED"
    )
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO user){
        UserDTO newUserDTO = userService.createUser(user);
        return new ResponseEntity<>(newUserDTO, HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get all Users",
            description = "It gets all users"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS OK"
    )
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> usersDTO = userService.getAllUsers();
        return new ResponseEntity<>(usersDTO, HttpStatus.OK);
    }
    @Operation(
            summary = "Get a User by ID",
            description = "It gets a user by ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS OK"
    )
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        UserDTO userDTO = userService.getUserByID(id);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
    @Operation(
            summary = "Update a User by ID",
            description = "It updates a user by ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS OK"
    )
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUserById(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO){
        UserDTO updatedUserDTO = userService.updateUserById(id,userDTO);
        return new ResponseEntity<>(updatedUserDTO, HttpStatus.OK);
    }
    @Operation(
            summary = "Delete a User by ID",
            description = "It deletes a user by ID"
    )
    @ApiResponse(
            responseCode = "204",
            description = "NO CONTENT"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return new ResponseEntity<>("User Deleted Successfully", HttpStatus.NO_CONTENT);
    }
}
