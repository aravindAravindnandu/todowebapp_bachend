package com.example.ToDo.List.App.requestDTO;




import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChangePasswordRequest {

	@NotBlank(message = "current password is mandatory")
	@Size(min = 4, max = 20, message = "The current password must be 4 from  to 20 characters.")
	private String currentPassword;
	@NotBlank(message = "new password is mandatory")
	@Size(min = 4, max = 20, message = "The new password must be from 4 to 20 characters.")
    private String newPassword;
	@NotBlank(message = "confirmation password is mandatory")
	@Size(min = 4, max = 20, message = "The confirmation password must be from 4 to 20 characters.")
    private String confirmationPassword;
}
