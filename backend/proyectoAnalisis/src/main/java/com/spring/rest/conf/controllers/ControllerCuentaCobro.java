package com.spring.rest.conf.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entidades.CuentaCobro;
import com.spring.logicaNegocio.ModCuentaCobro;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
public class ControllerCuentaCobro {

	// LogicaSolicitud
	ModCuentaCobro cuentaCobro = new ModCuentaCobro();

	// Validar si existe la cuenta de cobro
	@PostMapping("/validaCuentaCobro")
	Boolean validaExistencia(@RequestBody CuentaCobro cuentacobro) {
		Boolean existe = cuentaCobro.existe(cuentacobro.getIdProveedor(), cuentacobro.getMes());
		return existe;
	}

	// Traer cuenta de cobro
	@PostMapping("/traerNombreCuentaCobro")
	String traerNombre(@RequestBody CuentaCobro cuentacobro) {
		String nombre = cuentaCobro.nombre(cuentacobro.getIdProveedor(), cuentacobro.getMes());
		return nombre;
	}

	// Traer id cuenta de cobro
	@PostMapping("/traerIdCuentaCobro")
	int traerId(@RequestBody CuentaCobro cuentacobro) {
		int id = cuentaCobro.id(cuentacobro.getIdProveedor(), cuentacobro.getMes());
		System.out.println("helo");
		return 1;
	}

	// Añadir nueva cuenta de cobro
	@PostMapping("/añadirCuentaCobro")
	void añadirCuentaCobro(@RequestBody CuentaCobro cuentacobro) {
		cuentaCobro.añadirCuentaCobro(cuentacobro.getIdProveedor(),cuentacobro.getMes(),cuentacobro.getNombre());
	}
	
	// Traer cuenta de cobro
		@PostMapping("/traerCuentaCobro")
		CuentaCobro cuentaCobroTraer(@RequestBody CuentaCobro cuentacobro) {
			System.out.println("HELLO");
			CuentaCobro cuentaCobroS = cuentaCobro.cuentaCobro(cuentacobro.getIdProveedor(), cuentacobro.getMes());
			return cuentaCobroS;
		}
		
		

}
