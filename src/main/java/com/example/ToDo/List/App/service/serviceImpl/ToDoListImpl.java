package com.example.ToDo.List.App.service.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToDo.List.App.exception.ResourceNotFoundException;
import com.example.ToDo.List.App.model.ToDoList;
import com.example.ToDo.List.App.repository.ToDoListRepository;
import com.example.ToDo.List.App.requestDTO.ToDoListRequestDTO;
import com.example.ToDo.List.App.responseDTO.ToDoListResponseDTO;
import com.example.ToDo.List.App.service.ToDoListService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ToDoListImpl implements ToDoListService {

	@Autowired
	ToDoListRepository doListRepository;

	@Override
	public List<ToDoListResponseDTO> getAll() throws Exception {
		log.info("Entering to getAll method");
		return doListRepository.findAll().stream().map(ToDoListResponseDTO::new).toList();
	}

	@Override
	public ToDoListResponseDTO findById(Integer id) throws Exception {
		log.info("Entering to findById method");
		Optional<ToDoList> toDo = doListRepository.findById(id);
		ToDoListResponseDTO doListResponseDTO = new ToDoListResponseDTO();
		if (toDo.isPresent()) {
			doListResponseDTO = new ToDoListResponseDTO(toDo.get());
		} else {
			throw new ResourceNotFoundException("The given id: " + id + " is not found");
		}
		log.info("Exit from findById method");
		return doListResponseDTO;
	}

	@Override
	public ToDoListResponseDTO save(ToDoListRequestDTO requestDTO) throws Exception {
		log.info("Entering to save method");
		ToDoList doList = new ToDoList();
		if (requestDTO != null) {
			doList = requestDTO.convertToModel(requestDTO);
			doList = doListRepository.save(doList);
			log.info("The given data is saved");
		} else {
			throw new ResourceNotFoundException("The data might have some issues");
		}
		log.info("Exit from save method");
		return new ToDoListResponseDTO(doList);
	}

	@Override
	public ToDoListResponseDTO update(Integer id, ToDoListRequestDTO requestDTO) throws Exception {
		log.info("Entering to update method");
		Optional<ToDoList> toDo = doListRepository.findById(id);
		ToDoList doList = new ToDoList();
		if (toDo.isPresent()) {
			doList = requestDTO.convertToModel(toDo.get());
			doList.setModifiedDate(LocalDateTime.now());
			doList = doListRepository.save(doList);
			log.info("The given id : " + id + " is updated");
		} else {
			throw new ResourceNotFoundException("The given id : " + id + " is not updated");
		}
		log.info("Exit from update method");
		return new ToDoListResponseDTO(doList);
	}

	@Override
	public ToDoListResponseDTO delete(Integer id) throws Exception {
		log.info("Entering to delete method");
		Optional<ToDoList> toDo = doListRepository.findById(id);
		ToDoListResponseDTO doListResponseDTO = new ToDoListResponseDTO();
		if (toDo.isPresent()) {
			doListResponseDTO = new ToDoListResponseDTO(toDo.get());
			doListRepository.deleteById(id);
			log.info("The given id : " + id + " is deleted");
		} else {
			throw new ResourceNotFoundException("The given id : " + id + " is not deleted");
		}
		log.info("Exit from delete method");
		return doListResponseDTO;
	}

}
