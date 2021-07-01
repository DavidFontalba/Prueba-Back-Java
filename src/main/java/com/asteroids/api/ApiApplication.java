package com.asteroids.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@GetMapping("/asteroids")
	public String asteroids(@RequestParam(value = "planet", defaultValue = "NotAPlanet") String planet) {
		try {
			if (planet.equals("NotAPlanet")) throw new Exception("You must choose a planet!");
			return String.format("You said planet %s!", planet);
		} catch (Exception e) {
			return String.format(e.getMessage());
		}
	}
}