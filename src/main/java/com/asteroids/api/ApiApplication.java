package com.asteroids.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;

@SpringBootApplication
@RestController
public class ApiApplication {
	private String endpoint = "https://api.nasa.gov/neo/rest/v1/feed?";
	private String api_key = "&api_key=zdUP8ElJv1cehFM0rsZVSQN7uBVxlDnu4diHlLSb";

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@GetMapping("/asteroids")
	public Object asteroids(@RequestParam(value = "planet", defaultValue = "NotAPlanet") String planet) {
		try {
			if (planet.equals("NotAPlanet"))
				throw new Exception("You must choose a planet!");

			// return getAsteroids();
			return String.format("You said planet %s!", planet);
		} catch (Exception e) {
			return String.format(e.getMessage());
		}
	}

	private Object getAsteroids() {
		Date startDate = new Date();
		String startDateString = "start_date=" + (startDate.getYear()+1900) + "-" + (startDate.getMonth() + 1) + "-"
				+ startDate.getDate();

		Date endDate = new Date();
		endDate.setDate(startDate.getDate() + 7);
		String endDateString = "&end_date=" + (endDate.getYear()+1900) + "-" + (endDate.getMonth() + 1) + "-"
				+ endDate.getDate();

		try {
			URL url = new URL(endpoint + startDateString + endDateString + api_key);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

			return con.getContent();

		} catch (Exception e) {
			return "There was an error";

		}

	}
}
