package com.spring.rest.conf.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entidades.CuentaCobro;
import com.entidades.Solicitud;
import com.spring.logicaNegocio.ModSolicitud;

@RestController
public class ControllerSolicitud {

	// LogicaSolicitud
	ModSolicitud solicitud = new ModSolicitud();

	// Añadir nueva solicitud
	@PostMapping("/añadirSolicitud")
	void añadirSolicitud(@RequestBody Solicitud nuevaSolicitud) {
		solicitud.añadirSolicitud(nuevaSolicitud);
	}

	// Traer solicitudes
	@PostMapping("/traerSolicitudes")
	ArrayList<Solicitud> traerSolicitudes(@RequestBody CuentaCobro cuentaC) {
		ArrayList<Solicitud> solicitudes = solicitud.traerSolicitudes(cuentaC.getIdCuentaCobro());		
		return solicitudes;
	}

}
