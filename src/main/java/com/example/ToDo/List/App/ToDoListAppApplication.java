package com.example.ToDo.List.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class ToDoListAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListAppApplication.class, args);
	}

}
