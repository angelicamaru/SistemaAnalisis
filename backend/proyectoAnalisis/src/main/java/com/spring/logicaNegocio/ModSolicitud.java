package com.spring.logicaNegocio;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.entidades.Solicitud;
import com.entidades.Sponsor;

import basededatos.ConexionSolicitud;
import basededatos.ConexionSponsor;




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

	//Traer solicitudes
	public ArrayList<Solicitud> traerSolicitudes(int idCuentaCobro) {
		con = new ConexionSolicitud();
		ArrayList<Solicitud> solicitudes = con.solicitudes(idCuentaCobro);
	    con.desconectar();
		return solicitudes;
	}
	
	// Mod solicitud
		public void mod(Solicitud provMod) {
			con = new ConexionSolicitud();
			con.modS(provMod);
			con.desconectar();

		}

		// Eliminar solicitud
		public void eliminarS(Solicitud nombre) {
			con = new ConexionSolicitud();
			con.eliminarS(nombre);
			con.desconectar();

		}
}
