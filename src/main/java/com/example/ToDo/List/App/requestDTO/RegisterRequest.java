package com.example.ToDo.List.App.requestDTO;

import com.example.ToDo.List.App.enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  @NotBlank(message = "First Name is mandatory")
  @Size(min = 3, max = 15, message = "The First Name must be from 3 to 15 characters.")
  private String firstname;
  @Size(min = 1, max = 15, message = "The Second Name must be from 1 to 15 characters.")
  private String lastname;
  @NotBlank(message = "Email is mandatory")
  @Size(min = 10, max = 30, message = "The Email must be from 10 to 30 characters.")
  @Email
  private String email;
  @NotBlank(message = "Password is mandatory")
  @Size(min = 4, max = 20, message = "The Password must be from 4 to 20 characters.")
  private String password;
  @NotNull(message = "role is mandatory")
  private Role role;
}
