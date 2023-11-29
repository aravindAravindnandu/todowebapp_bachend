package com.example.ToDo.List.App.requestDTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

  @NotBlank(message = "Email is mandatory")
  @Size(min = 10, max = 30, message = "The Email must be from 10 to 30 characters.")
  @Email
  private String email;
  @NotBlank(message = "Password is mandatory")
  @Size(min = 6, max = 20, message = "The Password must be from 6 to 20 characters.")
  private String password;
}
