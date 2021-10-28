package com.spring.rest.conf.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entidades.CuentaCobro;
import com.spring.logicaNegocio.ModCuentaCobro;

@RestController
public class ControllerCuentaCobro {

	// LogicaSolicitud
	ModCuentaCobro cuentaCobro = new ModCuentaCobro();

	// Validar si existe la cuenta de cobro
	@PostMapping("/validaCuentaCobro")
	Boolean validaExistencia(@RequestBody CuentaCobro cuentacobro) {
		Boolean existe = cuentaCobro.existe(cuentacobro.getIdProveedor(), cuentacobro.getmes());
		return existe;
	}

	// Traer cuenta de cobro
	@PostMapping("/traerNombreCuentaCobro")
	String traerNombre(@RequestBody CuentaCobro cuentacobro) {
		String nombre = cuentaCobro.nombre(cuentacobro.getIdProveedor(), cuentacobro.getmes());
		return nombre;
	}

	// Traer id cuenta de cobro
	@PostMapping("/traerIdCuentaCobro")
	int traerId(@RequestBody CuentaCobro cuentacobro) {
		int id = cuentaCobro.id(cuentacobro.getIdProveedor(), cuentacobro.getmes());
		return id;
	}

	// Añadir nueva cuenta de cobro
	@PostMapping("/añadirCuentaCobro")
	void añadirCuentaCobro(@RequestBody CuentaCobro cuentacobro) {
		cuentaCobro.añadirCuentaCobro(cuentacobro.getIdProveedor(),cuentacobro.getmes(),cuentacobro.getNombre());
	}

}
