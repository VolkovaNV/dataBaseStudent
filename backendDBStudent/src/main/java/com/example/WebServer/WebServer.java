package com.example.WebServer;

import java.util.List;
import java.util.Map;

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
		private final SubjectRepository subjectRepository;
		private final JdbcTemplate jdbcTemplate;
		@Autowired
		public DataController(StudentRepository studentRepository, SpecialityRepository specialityRepository, SubjectRepository subjectRepository,
							  JdbcTemplate jdbcTemplate) {

			this.studentRepository = studentRepository;
			this.specialityRepository = specialityRepository;
			this.subjectRepository = subjectRepository;
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
		@PostMapping("/addSpeciality")
		public String addSpeciality(@RequestBody String specility){
			System.out.println("Received Speciality: " + specility);

			return specialityRepository.addSpeciality(specility);
		}

		@PostMapping("/addSubject")
		public String addSubject(@RequestBody String subject){
			System.out.println("Received Speciality: " + subject);

			return subjectRepository.addSubject(subject);
		}
		@GetMapping("/getTable")
		public List<Map<String, Object>> getStudentTable() {
			//String query = "SELECT * FROM \"Student\"";
			String query = "SELECT \"Student\".first_name, \"Student\".second_name, \"Student\".course, \"Student\".num_group, \"Speciality\".name_speciality\n" +
					"FROM \"Student\"\n" +
					"JOIN \"Speciality\" ON \"Student\".id_speciality = \"Speciality\".id_speciality;\n";
			return jdbcTemplate.queryForList(query);
		}
	}
}
