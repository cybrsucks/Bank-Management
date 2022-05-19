package com.example.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkApplication.class, args);
	}
}

/* Run this application, open RestMan to test **POST** method

Test input:

  {
    "userId": 3,
    "username": "willfack",
    "email": "willfack@kmail.net",
    "password": "williamfack"
  }

  Headers:

  Header:	content-type				Value:	application/json

 */