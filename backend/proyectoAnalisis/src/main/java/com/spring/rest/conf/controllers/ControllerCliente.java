package com.spring.rest.conf.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entidades.Cliente;
import com.entidades.Proveedor;
import com.spring.logicaNegocio.ModCliente;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
public class ControllerCliente {

	// LogicaSolicitud
	ModCliente cliente = new ModCliente();

	// Añadir nuevo cliente
	@PostMapping("/anadirCliente")
	void añadirCliente(@RequestBody Cliente nuevoCliente) {
		cliente.añadirCliente(nuevoCliente);
	}

	// Traer nombres de clientes
	@GetMapping("/traerNombresClientes")
	ArrayList<String> traerSolicitudes() {
		ArrayList<String> clientes = cliente.traerNombres();
		return clientes;
	}

	// Traer id de cliente
	@PostMapping("/traerIdCliente")
	int traerId(@RequestBody Cliente clienteS) {
		int id = cliente.id(clienteS.getNombre());
		return id;
	}

	// Modificar cliente
	@PostMapping("/modCliente")
	void modCliente(@RequestBody Cliente clienteMod) {
		cliente.mod(clienteMod);
	}

	// Eliminar cliente
	@PostMapping("/eliminarCliente")
	void deleteProveedor(@RequestBody Cliente nombreC) {
		cliente.eliminarC(nombreC);
	}

}
