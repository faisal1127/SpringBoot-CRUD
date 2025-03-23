package com.example.fd;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
		info = @Info(
				title = "Title of my Rest API Documentation",
				description = "Description of my Rest API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Faisal",
						email = "shaikfaisal1127@gmail.com",
						url = "https://www.google.com"
				),
				license = @License(
						name = "Apache 7.0",
						url = "https://www.google.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Description of external docs ",
				url = "https://www.google.com"
		)
)
@SpringBootApplication
public class FdApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(FdApplication.class, args);
	}

}
