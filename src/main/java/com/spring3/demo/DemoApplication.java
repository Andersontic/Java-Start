package com.spring3.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@RestController
@SpringBootApplication
public class DemoApplication {
	@RequestMapping("/")
	String LoadPage(){
		return "mensaje de saluad por servidor local";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.print("Prueba de aplicacioón");

	}

}
# src/main/resources/application.yml
		spring:
		security:
		oauth2:
		client:
		registration:
		auth0:
		client-id: bfs4NzlbB0g9mRFwlYD7ZaMzYlfiOnMj
		client-secret: YOUR_CLIENT_SECRET
		scope:
		- openid
		- profile
		- email
		provider:
		auth0:
		# trailing slash is important!
		issuer-uri: https://dev-fq4gell5.us.auth0.com/


