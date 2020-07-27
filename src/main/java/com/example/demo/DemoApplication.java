package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

import static com.example.demo.TeamsUtil.getTeamList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		getTeamList().add(new Team("Olympiakos", "athens", "Marinakis", 75000, "Europa League", 22, new Date()));
		SpringApplication.run(DemoApplication.class, args);
	}
}
