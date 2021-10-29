package com.spring.rest.conf.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entidades.CuentaCobro;
import com.entidades.Ejecucion;
import com.spring.logicaNegocio.ModCuentaCobro;
import com.spring.logicaNegocio.ModEjecucion;

@RestController
public class ControllerEjecucion {
	// LogicaEjecucion
		ModEjecucion ejecucion = new ModEjecucion();

		// Validar si existe la ejecucion
		@PostMapping("/validaEjecucion")
		Boolean validaExistencia(@RequestBody Ejecucion eje) {
			Boolean existe = ejecucion.existe(eje.getIdCliente(), eje.getMes());
			return existe;
		}

		// Traer nombre de ejecucion
		@PostMapping("/traerNombreEjecucion")
		String traerDescripcion(@RequestBody Ejecucion eje) {
			String descripcion = ejecucion.descripcion(eje.getIdCliente(), eje.getMes());
			return descripcion;
		}

		// Traer id de ejecucion
		@PostMapping("/traerIdEjecucion")
		int traerId(@RequestBody Ejecucion eje) {
			int id = ejecucion.id(eje.getIdCliente(), eje.getMes());
			return id;
		}

		// Añadir nueva ejecucion
		@PostMapping("/añadirEjecucion")
		void añadirEjecucion(@RequestBody Ejecucion eje) {
			System.out.println(eje);
			System.out.println(eje.getIdCliente());
			ejecucion.añadirEjecucion(eje.getIdCliente(), eje.getMes(), eje.getDescripcion());
		}
		
		
		
}
