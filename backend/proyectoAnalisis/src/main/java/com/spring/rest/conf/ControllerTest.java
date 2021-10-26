package com.spring.rest.conf;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {

	@GetMapping("/hello")
	String saludo() {
		return "Hola";
	}
	
}
