package com.spring.rest.conf.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import com.entidades.Sponsor;
import com.spring.logicaNegocio.ModSponsor;


@RestController
public class ControllerSponsor {

	// Logica
	ModSponsor sponsor = new ModSponsor();

	// Añadir nuevo sponsor
	@PostMapping("/añadirSponsor")
	void añadirSponsor(@RequestBody Sponsor nuevoSponsor) {
		sponsor.añadirSponsor(nuevoSponsor);
	}

	// Traer nombres de sponsor
	@PostMapping("/traerNombresSponsors")
	ArrayList<String> traerSolicitudes() {
		ArrayList<String> sponsors = sponsor.traerNombres();
		return sponsors;
	}

	// Traer id del sponsor
	@PostMapping("/traerId")
	String traerId(@RequestBody String nombre) {
		String id = sponsor.id(nombre);
		return id;
	}

}
