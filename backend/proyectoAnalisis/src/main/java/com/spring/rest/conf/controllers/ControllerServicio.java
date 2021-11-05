package com.spring.rest.conf.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entidades.Solicitud;
import com.entidades.Servicio;
import com.spring.logicaNegocio.ModServicio;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
public class ControllerServicio {

	// Logica
	ModServicio servicio = new ModServicio();

	// Añadir nuevo servicio
	@PostMapping("/añadirServicio")
	void añadirServicio(@RequestBody Servicio nuevoServicio) {
		servicio.añadirServicio(nuevoServicio);
	}

	// Traer nombres de servicio
	@GetMapping("/traerNombresServicios")
	ArrayList<String> traerSolicitudes() {
		ArrayList<String> servicios = servicio.traerNombres();
		return servicios;
	}

	// Traer id del servicio
	@PostMapping("/traerIdServicio")
	int traerId(@RequestBody Servicio serv) {
		int id = servicio.id(serv.getNombre());
		return id;
	}

	// Modificar servicio
	@PostMapping("/modServicio")
	void modCliente(@RequestBody Servicio serv) {
		servicio.mod(serv);
	}

	// Eliminar servicio
	@PostMapping("/eliminarServicio")//Envía el id del servicio a eliminar
	void deleteProveedor(@RequestBody Servicio idServ) {
		servicio.eliminarS(idServ);
	}

}
