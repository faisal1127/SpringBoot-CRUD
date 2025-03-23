package com.example.fd.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;

    @NotEmpty(message = "User firstName can't be empty.")
    private String firstName;

    @NotEmpty(message = "User lastName can't be empty.")
    private String lastName;

    @NotEmpty(message = "User e-mail can't be empty.")
    @Email(message = "User e-mail must be valid.")
    private String email;
}
