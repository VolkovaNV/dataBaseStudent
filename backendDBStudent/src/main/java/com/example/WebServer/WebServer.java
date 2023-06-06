package com.example.WebServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class WebServer {
	@CrossOrigin(origins = "*") // Разрешаем запросы с любого источника
	@RestController
	public static class DataController {
		@PostMapping("/data")
		public String postData(@RequestBody String data) {
			System.out.println("Received data: " + data);

			// Здесь вы можете добавить логику для обработки данных
			// и записи их в таблицу на PostgreSQL

			return data;
		}
	}
}