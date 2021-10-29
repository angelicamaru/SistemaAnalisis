package com.spring.logicaNegocio;

import java.util.ArrayList;

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

	public ArrayList<Solicitud> traerSolicitudes(int idCuentaCobro) {
		con = new ConexionSolicitud();
		ArrayList<Solicitud> solicitudes = con.solicitudes(idCuentaCobro);
	    con.desconectar();
		return solicitudes;
	}
}
