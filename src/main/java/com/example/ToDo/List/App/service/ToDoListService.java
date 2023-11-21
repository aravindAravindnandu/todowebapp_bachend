package com.example.ToDo.List.App.service;

import java.util.List;

import com.example.ToDo.List.App.requestDTO.ToDoListRequestDTO;
import com.example.ToDo.List.App.responseDTO.ToDoListResponseDTO;

/**
 * Service class for toDoWebApp
 * 
 * @author Aravind
 *
 */
public interface ToDoListService {
	/**
	 * FindAll for ToDoList
	 * 
	 * @return List of ToDoListResponseDTO
	 * @throws Exception
	 */
	List<ToDoListResponseDTO> getAll() throws Exception;

	/**
	 * FindById for ToDoList
	 * 
	 * @return ToDoListResponseDTO
	 * @throws Exception
	 */
	ToDoListResponseDTO findById(Integer id) throws Exception;

	/**
	 * save for ToDoList
	 * 
	 * @return ToDoListResponseDTO
	 * @throws Exception
	 */
	ToDoListResponseDTO save(ToDoListRequestDTO requestDTO) throws Exception;

	/**
	 * update for ToDoList
	 * 
	 * @return ToDoListResponseDTO
	 * @throws Exception
	 */
	ToDoListResponseDTO update(Integer id, ToDoListRequestDTO requestDTO) throws Exception;

	/**
	 * delete for ToDoList
	 * 
	 * @return ToDoListResponseDTO
	 * @throws Exception
	 */
	ToDoListResponseDTO delete(Integer id) throws Exception;
}
