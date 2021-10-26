package com.spring.logicaNegocio;

import com.entidades.CuentaCobro;
import com.entidades.Ejecucion;

import basededatos.ConexionCuentaCobro;
import basededatos.ConexionEjecucion;

public class ModEjecucion {
	
	// Objetos
		Ejecucion ejecucion = new Ejecucion();
		ConexionEjecucion con;

		// Metodos

		// Validar existencia ejecucion
		public Boolean existe(String idCliente, String mes) {
			con = new ConexionEjecucion();
			boolean existe = con.existe(idCliente, mes);
			con.desconectar();
			return existe;

		}

		// Retorna descripcion de ejecucion
		public String descripcion(String idCliente, String mes) {
			con = new ConexionEjecucion();
			String descripcion = con.descripcion(idCliente, mes);
			con.desconectar();
			return descripcion;

		}
		
		// Retorna el id de ejecucion
			public String id(String idCliente, String mes) {
				con = new ConexionEjecucion();
				String id = con.id(idCliente, mes);
				con.desconectar();
				return id;

			}

		// Crear nueva ejecucion
		public void añadirEjecucion(String idCliente, String mes, String descripcion) {
			con = new ConexionEjecucion();
			con.nuevaEjecucion(idCliente, mes,descripcion);
			con.desconectar();
			

		}
}
