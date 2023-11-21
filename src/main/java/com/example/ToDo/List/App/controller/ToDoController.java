package com.example.ToDo.List.App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ToDo.List.App.requestDTO.ToDoListRequestDTO;
import com.example.ToDo.List.App.responseDTO.ToDoListResponseDTO;
import com.example.ToDo.List.App.service.ToDoListService;
/**
 * Controller class created for toDoWebApp
 * @author Aravind
 *
 */
@RestController
@RequestMapping("/todo-webapp")
public class ToDoController {
	@Autowired
	ToDoListService doListService;

	@GetMapping("/getAll")
	public ResponseEntity<List<ToDoListResponseDTO>> getAll() throws Exception {
		return ResponseEntity.ok(doListService.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ToDoListResponseDTO> findById(@PathVariable Integer id) throws Exception {
		return ResponseEntity.ok(doListService.findById(id));
	}

	@PostMapping("/save")
	public ResponseEntity<ToDoListResponseDTO> save(@RequestBody ToDoListRequestDTO requestDTO) throws Exception {
		return ResponseEntity.ok(doListService.save(requestDTO));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ToDoListResponseDTO> update(@PathVariable Integer id,
			@RequestBody ToDoListRequestDTO requestDTO) throws Exception {
		return ResponseEntity.ok(doListService.update(id, requestDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ToDoListResponseDTO> delete(@PathVariable Integer id) throws Exception {
		return ResponseEntity.ok(doListService.delete(id));
	}

}
