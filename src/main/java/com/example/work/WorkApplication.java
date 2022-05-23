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

	**Test inputs:**

	POST method:

  {
    "userId": 1,
    "username": "willfack",
    "email": "willfack@kmail.net",
    "password": "williamfack"
  },
  {
    "userId": 2 ,
    "username": "mike",
    "email": "excel@kmail.net",
    "password": "heavyisthehand"
  }

  Headers:

  Header:	content-type				Value:	application/json


	UPDATE method:
	http://localhost:8080/api/v1/user/2?username=Michael&email=miccheck@kmail.net&password=MickeyMouseClubhouse
 */