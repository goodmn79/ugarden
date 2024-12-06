package com.gdmn.ugarden;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class UgardenApplication {

	public static void main(String[] args) {
		SpringApplication.run(UgardenApplication.class, args);
	}

}
