package com.spring.rest.conf.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUser {

	@GetMapping("/addUser")
	String saludo() {
		return "Hola!!";
	}
	
}
