package com.example.WebServer;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@SpringBootApplication
public class WebServer {
	@CrossOrigin(origins = "*") // Разрешаем запросы с любого источника
	@RestController
	public static class DataController {
		private final StudentRepository studentRepository;
		private final JdbcTemplate jdbcTemplate;
		@Autowired
		public DataController(StudentRepository studentRepository, JdbcTemplate jdbcTemplate) {

			this.studentRepository = studentRepository;
			this.jdbcTemplate = jdbcTemplate;
		}
		@PostMapping("/addStudent")
		public Student addStudent(@RequestBody Student student) {
			System.out.println("Фамилия: " + student.getFirstName());
			System.out.println("Имя: " + student.getSecondName());
			System.out.println("Номер спициальности: " + student.getSpecialityNumber());
			System.out.println("Курс: " + student.getCourse());
			System.out.println("Номер группы: " + student.getGroupNumber());

			// Здесь вы можете добавить логику для обработки данных
			// и записи их в таблицу на PostgreSQL
			return studentRepository.addStudent(student);

			//return student;//new ResponseEntity<>(name, HttpStatus.OK);
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
