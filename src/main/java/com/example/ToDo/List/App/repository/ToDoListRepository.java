package com.example.ToDo.List.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.ToDo.List.App.model.ToDoList;

/**
 * Repository created for toDoWebApp
 * @author Aravind
 *
 */
@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Integer>, JpaSpecificationExecutor<ToDoList>{

}
