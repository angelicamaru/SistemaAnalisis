package com.spring.rest.conf.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entidades.Cliente;
import com.entidades.Solicitud;
import com.spring.logicaNegocio.ModCliente;
import com.spring.logicaNegocio.ModSolicitud;

@RestController
public class ControllerCliente {

	// LogicaSolicitud
	ModCliente cliente = new ModCliente();

	// Añadir nuevo cliente
	@PostMapping("/añadirCliente")
	void añadirCliente(@RequestBody Cliente nuevoCliente) {
		cliente.añadirCliente(nuevoCliente);
	}

	// Traer nombres de clientes
	@PostMapping("/traerNombresClientes")
	ArrayList<String> traerSolicitudes() {
		ArrayList<String> clientes = cliente.traerNombres();
		return clientes;
	}

	// Traer id de cliente
	@PostMapping("/traerId")
	String traerId(@RequestBody String nombre) {
		String id = cliente.id(nombre);
		return id;
	}

}
