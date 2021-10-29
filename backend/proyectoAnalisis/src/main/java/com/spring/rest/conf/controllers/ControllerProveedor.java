package com.spring.rest.conf.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entidades.Cliente;
import com.entidades.Proveedor;
import com.entidades.Solicitud;
import com.spring.logicaNegocio.ModCliente;
import com.spring.logicaNegocio.ModProveedor;
import com.spring.logicaNegocio.ModSolicitud;

@RestController
public class ControllerProveedor {

	// LogicaSolicitud
	ModProveedor proveedor = new ModProveedor();

	// Añadir nuevo proveedor
	@PostMapping("/añadirProveedor")
	void añadirProveedor(@RequestBody Proveedor nuevoProveedor) {
		proveedor.añadirProveedor(nuevoProveedor);
	}

	// Traer nombres de proveedores
	@PostMapping("/traerNombresProveedores")
	ArrayList<String> traerSolicitudes() {
		ArrayList<String> proveedores = proveedor.traerNombres();
		return proveedores;
	}

	// Traer id del proveedor
	@PostMapping("/traerIdProveedor")
	int traerId(@RequestBody Proveedor proo) {
		int id = proveedor.id(proo.getNombre());
		return id;
	}

}
