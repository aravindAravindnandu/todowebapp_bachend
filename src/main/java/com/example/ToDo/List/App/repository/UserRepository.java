package com.example.ToDo.List.App.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ToDo.List.App.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

}
