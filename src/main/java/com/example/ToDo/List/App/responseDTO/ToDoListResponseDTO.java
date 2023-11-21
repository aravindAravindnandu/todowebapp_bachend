package com.example.ToDo.List.App.responseDTO;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;

import com.example.ToDo.List.App.enums.Status;
import com.example.ToDo.List.App.model.ToDoList;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoListResponseDTO {
	private Integer toDoListId;
	private String title;
	private String description;
	private LocalDateTime creationDate;
	private String createdUser;
	private LocalDateTime modifiedDate;
	private String modifiedUser;
	private String estimatedTimeToCompletion;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public ToDoListResponseDTO(ToDoList doList) {
		BeanUtils.copyProperties(doList, this);
	}
}
