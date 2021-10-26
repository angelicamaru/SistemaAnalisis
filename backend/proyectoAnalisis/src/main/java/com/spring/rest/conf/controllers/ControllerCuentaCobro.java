package com.spring.rest.conf.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.spring.logicaNegocio.ModCuentaCobro;

@RestController
public class ControllerCuentaCobro {

	// LogicaSolicitud
	ModCuentaCobro cuentaCobro = new ModCuentaCobro();

	// Validar si existe la cuenta de cobro
	@PostMapping("/validaCuentaCobro")
	Boolean validaExistencia(@RequestBody String idProveedor, String mes) {
		Boolean existe = cuentaCobro.existe(idProveedor, mes);
		return existe;
	}

	// Traer cuenta de cobro
	@PostMapping("/traerNombre")
	String traerNombre(@RequestBody String idProveedor, String mes) {
		String nombre = cuentaCobro.nombre(idProveedor, mes);
		return nombre;
	}

	// Traer cuenta de cobro
	@PostMapping("/traerId")
	String traerId(@RequestBody String idProveedor, String mes) {
		String id = cuentaCobro.id(idProveedor, mes);
		return id;
	}

	// Añadir nueva cuenta de cobro
	@PostMapping("/añadirCuentaCobro")
	void añadirCuentaCobro(@RequestBody String idProveedor, String mes, String nombre) {
		cuentaCobro.añadirCuentaCobro(idProveedor, mes, nombre);
	}

}
