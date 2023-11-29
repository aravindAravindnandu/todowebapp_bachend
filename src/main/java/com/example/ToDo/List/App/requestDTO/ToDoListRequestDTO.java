package com.example.ToDo.List.App.requestDTO;

import org.springframework.beans.BeanUtils;

import com.example.ToDo.List.App.enums.Status;
import com.example.ToDo.List.App.model.ToDoList;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ToDoListRequestDTO {
	@Size(min = 4, max = 15, message = "The title must be from 4 to 15 characters.")
	private String title;
	@Size(min = 6, max = 50, message = "The description must be from 6 to 50 characters.")
	private String description;
	@Size(min = 3, max = 10, message = "The estimatedTimeToCompletion must be from 3 to 10 characters.")
	private String estimatedTimeToCompletion;
	@Enumerated(EnumType.STRING)
	private Status status;

	public ToDoList convertToModel(ToDoList toDoList) {
		if (StringUtils.isNotBlank(this.title)) {
			toDoList.setTitle(this.title);
		}
		if (StringUtils.isNotBlank(this.description)) {
			toDoList.setDescription(this.description);
		}
		if (StringUtils.isNotBlank(this.estimatedTimeToCompletion)) {
			toDoList.setEstimatedTimeToCompletion(this.estimatedTimeToCompletion);
		}
		if (this.status != null) {
			toDoList.setStatus(this.status);
		}
		return toDoList;
	}

	public ToDoList convertToModel(ToDoListRequestDTO requestDTO) {
		BeanUtils.copyProperties(requestDTO, this);
		return new ToDoList(this);
	}

}
