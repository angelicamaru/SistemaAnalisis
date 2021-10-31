package com.spring.rest.conf.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.entidades.Sponsor;
import com.spring.logicaNegocio.ModSponsor;


@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
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
	@PostMapping("/traerIdSponsor")
	int traerId(@RequestBody Sponsor spons) {
		int id = sponsor.id(spons.getNombre());
		return id;
	}

}
