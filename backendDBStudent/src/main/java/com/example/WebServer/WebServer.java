package com.example.WebServer;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class WebServer {
	@CrossOrigin(origins = "*") // Разрешаем запросы с любого источника
	@RestController
	public static class DataController {
		@PostMapping("/addStudent")
		public Student addStudent(@RequestBody Student student) {
			//System.out.println("Received data: " + student.getFirstName().getClass().getName());

			// Здесь вы можете добавить логику для обработки данных
			// и записи их в таблицу на PostgreSQL



			return student;//new ResponseEntity<>(name, HttpStatus.OK);
		}

		@PostMapping("/addSpeciality")
		public String addSubject(@RequestBody String subject) {
			System.out.println("Received Speciality: " + subject);

			// Здесь вы можете добавить логику для обработки данных
			// и записи их в таблицу на PostgreSQL

			return subject;
		}
	}
}
