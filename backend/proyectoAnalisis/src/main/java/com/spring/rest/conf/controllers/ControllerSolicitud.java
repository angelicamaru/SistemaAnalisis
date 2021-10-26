package com.spring.rest.conf.controllers;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entidades.Solicitud;
import com.spring.logicaNegocio.ModSolicitud;

@RestController
public class ControllerSolicitud {

	//LogicaSolicitud
		ModSolicitud solicitud = new ModSolicitud();
		
		
	//Añadir nueva solicitud	
	@PostMapping("/añadirSolicitud")
	void añadirSolicitud(@RequestBody Solicitud nuevaSolicitud) {
		solicitud.añadirSolicitud(nuevaSolicitud);
	}
	
	
}
