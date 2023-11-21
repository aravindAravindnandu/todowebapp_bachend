package com.example.ToDo.List.App.requestDTO;

import org.springframework.beans.BeanUtils;

import com.example.ToDo.List.App.enums.Status;
import com.example.ToDo.List.App.model.ToDoList;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ToDoListRequestDTO {
	private String title;
	private String description;
	private String estimatedTimeToCompletion;
	@Enumerated(EnumType.STRING)
	private Status status;
	
//	public ToDoList convertToModel() {
//		ToDoList toDoList = new ToDoList();
//		BeanUtils.copyProperties(this, toDoList);
//		return toDoList;
//	}
	
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
