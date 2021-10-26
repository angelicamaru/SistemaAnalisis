package com.spring.logicaNegocio;

import org.springframework.stereotype.Service;

import com.entidades.Solicitud;

import basededatos.ConexionSolicitud;




@Service
public class ModSolicitud {
	
	//Objetos
	Solicitud solicitud = new Solicitud();
	ConexionSolicitud con;

	//Metodos
	
	//Añadir solicitud
	public void añadirSolicitud(Solicitud solicitudNueva) {
		con = new ConexionSolicitud();
	    con.solicitudNueva(solicitudNueva);
	    con.desconectar();
		
	}
}
