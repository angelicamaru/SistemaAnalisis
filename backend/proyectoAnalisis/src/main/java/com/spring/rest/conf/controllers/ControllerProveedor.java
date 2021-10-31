package com.spring.rest.conf.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entidades.Cliente;
import com.entidades.Proveedor;
import com.entidades.Solicitud;
import com.spring.logicaNegocio.ModCliente;
import com.spring.logicaNegocio.ModProveedor;
import com.spring.logicaNegocio.ModSolicitud;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
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
	@GetMapping("/traerNombresProveedores")
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

	// Modificar proveedor
	@PostMapping("/modProveedor")
	void modCliente(@RequestBody Proveedor proo) {
		proveedor.mod(proo);
	}

	// Eliminar proveedor
	@PostMapping("/eliminarProveedor")
	void deleteProveedor(@RequestBody Proveedor nombreP) {
		proveedor.eliminarP(nombreP);
	}

}
