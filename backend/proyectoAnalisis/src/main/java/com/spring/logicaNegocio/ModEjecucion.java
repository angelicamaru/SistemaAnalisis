package com.spring.logicaNegocio;

import java.util.ArrayList;

import com.entidades.CuentaCobro;
import com.entidades.Ejecucion;
import com.entidades.Solicitud;

import basededatos.ConexionCuentaCobro;
import basededatos.ConexionEjecucion;

public class ModEjecucion {
	
	// Objetos
		Ejecucion ejecucion = new Ejecucion();
		ConexionEjecucion con;

		// Metodos

		// Validar existencia ejecucion
		public Boolean existe(int idCliente, String mes) {
			con = new ConexionEjecucion();
			boolean existe = con.existe(idCliente, mes);
			con.desconectar();
			return existe;

		}

		// Retorna descripcion de ejecucion
		public String descripcion(int idCliente, String mes) {
			con = new ConexionEjecucion();
			String descripcion = con.descripcion(idCliente, mes);
			con.desconectar();
			return descripcion;

		}
		
		// Retorna el id de ejecucion
			public int id(int idCliente, String mes) {
				con = new ConexionEjecucion();
				int id = con.id(idCliente, mes);
				con.desconectar();
				return id;

			}

		// Crear nueva ejecucion
		public void añadirEjecucion(int idCliente, String mes, String descripcion) {
			con = new ConexionEjecucion();
			con.nuevaEjecucion(idCliente, mes,descripcion);
			con.desconectar();
			

		}

		//Traer cuenta de cobro
		public Ejecucion traerEjecucion(int idCliente, String mes) {
			con = new ConexionEjecucion();
			
			ModSolicitud solicitud = new ModSolicitud();
			
			int id = con.id(idCliente, mes);
			String descripcion = con.descripcion(idCliente, mes);
			ArrayList<Solicitud> solicitudes = solicitud.traerSolicitudesPrecio(id);	
			double total = con.total(id);
			
			System.out.println(total);
			Ejecucion eje = new Ejecucion(id,descripcion,mes, idCliente,solicitudes,total);
			con.desconectar();
			return eje;
		}
}
