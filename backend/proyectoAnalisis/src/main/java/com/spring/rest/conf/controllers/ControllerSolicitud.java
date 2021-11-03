package com.spring.rest.conf.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entidades.Cliente;
import com.entidades.CuentaCobro;
import com.entidades.Solicitud;
import com.spring.logicaNegocio.ModSolicitud;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
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
	

	// Modificar solicitud
		@PostMapping("/modSolicitud")//Envío del objeto modificado
		void modCliente(@RequestBody Solicitud idSol) {
			solicitud.mod(idSol);
		}

		// Eliminar cliente
		@PostMapping("/eliminarSolicitud")//Envío del id de la solicitud a eliminar
		void deleteProveedor(@RequestBody Solicitud idSol) {
			solicitud.eliminarS(idSol);
		}

		// Traer nombres de clientes
		@GetMapping("/traerNombresSolicitudes")
		ArrayList<String> traerSolicitudes() {
			ArrayList<String> clientes = cliente.traerNombres();
			return clientes;
		}
}
