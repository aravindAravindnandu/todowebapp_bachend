package com.example.ToDo.List.App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import jakarta.validation.Valid;
/**
 * Controller class created for toDoWebApp
 * @author Aravind
 *
 */
@RestController
@RequestMapping("/todo-webapp")
@PreAuthorize("hasRole('ADMIN','USER')")
public class ToDoController {
	@Autowired
	ToDoListService doListService;

	@GetMapping("/getAll")
	@PreAuthorize("hasAuthority('admin:read') or hasAuthority('user:read')")
	public ResponseEntity<List<ToDoListResponseDTO>> getAll() throws Exception {
		return ResponseEntity.ok(doListService.getAll());
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('user:read')")
	public ResponseEntity<ToDoListResponseDTO> findById(@Valid @PathVariable Integer id) throws Exception {
		return ResponseEntity.ok(doListService.findById(id));
	}

	@PostMapping("/save")
	@PreAuthorize("hasAuthority('user:create')")
	public ResponseEntity<ToDoListResponseDTO> save(@Valid @RequestBody ToDoListRequestDTO requestDTO) throws Exception {
		return ResponseEntity.ok(doListService.save(requestDTO));
	}

	@PutMapping("/update/{id}")
	@PreAuthorize("hasAuthority('user:update')")
	public ResponseEntity<ToDoListResponseDTO> update(@Valid @PathVariable Integer id,
		@Valid	@RequestBody ToDoListRequestDTO requestDTO) throws Exception {
		return ResponseEntity.ok(doListService.update(id, requestDTO));
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('user:delete')")
	public ResponseEntity<ToDoListResponseDTO> delete(@Valid @PathVariable Integer id) throws Exception {
		return ResponseEntity.ok(doListService.delete(id));
	}

}
