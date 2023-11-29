package com.example.ToDo.List.App.model;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.ToDo.List.App.enums.Status;
import com.example.ToDo.List.App.requestDTO.ToDoListRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="todolist")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ToDoList {
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer toDoListId;
	private String title;
	private String description;
	@CreationTimestamp
	private LocalDateTime creationDate;
	@CreatedBy
	private String createdUser;
	@UpdateTimestamp
	private LocalDateTime modifiedDate;
	@LastModifiedBy
	private String modifiedUser;
	private String estimatedTimeToCompletion;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public ToDoList(ToDoListRequestDTO requestDTO) {
		BeanUtils.copyProperties(requestDTO, this);
	}

}
