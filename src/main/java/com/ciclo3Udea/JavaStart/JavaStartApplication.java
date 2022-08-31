package com.ciclo3Udea.JavaStart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})
public class JavaStartApplication {
	@GetMapping("/start")
	public String start() {
		return "Hola Bienvenidos al Grupo Java-Start";
	}



	public static void main(String[] args) {
		SpringApplication.run(JavaStartApplication.class, args);
		System.out.println("Hola Mundo");
	}


}
