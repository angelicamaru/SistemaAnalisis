package com.spring.rest.conf.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.logicaNegocio.ModCuentaCobro;
import com.spring.logicaNegocio.ModEjecucion;

public class ControllerEjecucion {
	// LogicaEjecucion
		ModEjecucion ejecucion = new ModEjecucion();

		// Validar si existe la ejecucion
		@PostMapping("/validaEjecucion")
		Boolean validaExistencia(@RequestBody String idCliente, String mes) {
			Boolean existe = ejecucion.existe(idCliente, mes);
			return existe;
		}

		// Traer nombre de ejecucion
		@PostMapping("/traerNombre")
		String traerDescripcion(@RequestBody String idCliente, String mes) {
			String descripcion = ejecucion.descripcion(idCliente, mes);
			return descripcion;
		}

		// Traer id de ejecucion
		@PostMapping("/traerId")
		String traerId(@RequestBody String idCliente, String mes) {
			String id = ejecucion.id(idCliente, mes);
			return id;
		}

		// Añadir nueva ejecucion
		@PostMapping("/añadirEjecucion")
		void añadirEjecucion(@RequestBody String idCliente, String mes, String descripcion) {
			ejecucion.añadirEjecucion(idCliente, mes, descripcion);
		}
}
