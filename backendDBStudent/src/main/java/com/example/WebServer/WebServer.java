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
		private final SpecialityRepository specialityRepository;
		private final JdbcTemplate jdbcTemplate;
		@Autowired
		public DataController(StudentRepository studentRepository, SpecialityRepository specialityRepository,
							  JdbcTemplate jdbcTemplate) {

			this.studentRepository = studentRepository;
			this.specialityRepository = specialityRepository;
			this.jdbcTemplate = jdbcTemplate;
		}
		@PostMapping("/addStudent")
		public Student addStudent(@RequestBody Student student) {
			System.out.println("Фамилия: " + student.getFirstName());
			System.out.println("Имя: " + student.getSecondName());
			System.out.println("Номер спициальности: " + student.getSpecialityNumber());
			System.out.println("Курс: " + student.getCourse());
			System.out.println("Номер группы: " + student.getGroupNumber());


			return studentRepository.addStudent(student);
		}

//		@PostMapping("/addSpeciality")
//		public Speciality addSpeciality(@RequestBody Speciality speciality) {
//			System.out.println("Received Speciality: " + speciality.getSpeciality());
//
//			return specialityRepository.addSpeciality(speciality);
//		}
		@PostMapping("/addSpeciality")
		public String addSpeciality(@RequestBody String specility){
			System.out.println("Received Speciality: " + specility);

			return specialityRepository.addSpeciality(specility);
		}
	}
}
