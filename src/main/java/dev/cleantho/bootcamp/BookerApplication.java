package dev.cleantho.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

// CORS FIX FOR SWAGGER
@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server URL")})
@SpringBootApplication
public class BookerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookerApplication.class, args);
	}

}
