package com.spring.logicaNegocio;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.entidades.Solicitud;
import com.entidades.SolicitudMapper;
import com.entidades.Sponsor;

import basededatos.ConexionCliente;
import basededatos.ConexionSolicitud;
import basededatos.ConexionSponsor;




@Service
public class ModSolicitud {
	
	//Objetos
	Solicitud solicitud;
	ModEntregable entregable = new ModEntregable();
	ModEjecucion ejecucion = new ModEjecucion();
	ModCliente cliente = new ModCliente();
	ModSponsor sponsor = new ModSponsor();
	ModServicio servicio = new ModServicio();
	ModCuentaCobro cuentaCobro = new ModCuentaCobro();
	ConexionSolicitud con;

	//Metodos
	
	//Añadir solicitud
	public void añadirSolicitud(SolicitudMapper nuevaSolicitud) {
		con = new ConexionSolicitud();
		
		
		int idEntregable = entregable.id(nuevaSolicitud.getNombreEntregable());
		int idCliente = cliente.id(nuevaSolicitud.getNombreCliente());
		int idEjecucion = ejecucion.id(idCliente,nuevaSolicitud.getMes());
		int idSponsor = sponsor.id(nuevaSolicitud.getNombreSponsor());
		int idServicio = servicio.id(nuevaSolicitud.getNombreServicio());
		int idProveedor = 1;
		int idCuentaCobro = cuentaCobro.id(idProveedor, nuevaSolicitud.getMes());
		
		
		solicitud = new Solicitud(nuevaSolicitud.getNombreSolicitud(),
				nuevaSolicitud.getCantidad(),nuevaSolicitud.getFecha(),idEntregable,idEjecucion,idSponsor,idServicio,idCuentaCobro);
		
	    con.solicitudNueva(solicitud);
	    con.desconectar();
		
	}

	//Traer solicitudes
	public ArrayList<Solicitud> traerSolicitudes(int idCuentaCobro) {
		con = new ConexionSolicitud();
		ArrayList<Solicitud> solicitudes = con.solicitudes(idCuentaCobro);
	    con.desconectar();
		return solicitudes;
	}
	
	//Traer solicitudes con precio
		public ArrayList<Solicitud> traerSolicitudesPrecio(int idCuentaCobro) {
			con = new ConexionSolicitud();
			ArrayList<Solicitud> solicitudes = con.solicitudesPrecio(idCuentaCobro);
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
		
		// Retorna el nombres de solicitudes
		public ArrayList<String> traerNombres() {
			con = new ConexionSolicitud();
			ArrayList<String> nombres = con.traerNombres();
			con.desconectar();
			return nombres;

		}
}
