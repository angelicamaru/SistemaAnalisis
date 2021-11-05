package com.spring.rest.conf.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


import com.entidades.Entregable;
import com.spring.logicaNegocio.ModEntregable;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
public class ControllerEntregable {

	// LogicaSolicitud
	ModEntregable entregable = new ModEntregable();

	// Añadir nuevo Entregable
	@PostMapping("/anadirEntregable")
	void añadirEntregable(@RequestBody Entregable nuevoEntregable) {
		entregable.añadirEntregable(nuevoEntregable);
	}

	// Traer nombres de Entregable
	@GetMapping("/traerNombresEntregables")
	ArrayList<String> traerEntregables() {
		ArrayList<String> entregables = entregable.traerNombres();
		return entregables;
	}
        
        // Traer info. de Entregable
	@GetMapping("/traerTodoEntregables")
	ArrayList<Entregable> traerTodo() {
		ArrayList<Entregable> entregables = entregable.traerTodo();
		return entregables;
	}

	// Traer id de Entregable
	@PostMapping("/traerIdEntregable")
	int traerId(@RequestBody Entregable clienteS) {
		int id = entregable.id(clienteS.getEntregable());
		return id;
	}

	// Modificar Entregable
	@PostMapping("/modEntregable")
	void modEntregable(@RequestBody Entregable entregableMod) {
		entregable.mod(entregableMod);
	}

	// Eliminar Entregable
	@PostMapping("/eliminarEntregable")
	void deleteEntregable(@RequestBody Entregable nombreC) {
		System.out.println(nombreC.getEntregable()+"entre");
		entregable.eliminarC(nombreC);
	}

}
