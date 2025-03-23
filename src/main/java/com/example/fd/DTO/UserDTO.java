package com.example.fd.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "User Resource")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @Schema(description = "User ID")
    private Long id;

    @Schema(description = "User firstname")
    @NotEmpty(message = "User firstName can't be empty.")
    private String firstName;

    @Schema(description = "User lastname")
    @NotEmpty(message = "User lastName can't be empty.")
    private String lastName;

    @Schema(description = "User e-mail")
    @NotEmpty(message = "User e-mail can't be empty.")
    @Email(message = "User e-mail must be valid.")
    private String email;
}
