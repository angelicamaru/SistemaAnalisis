package com.spring.logicaNegocio;

import org.springframework.stereotype.Service;

import com.entidades.CuentaCobro;

import basededatos.ConexionCuentaCobro;

@Service
public class ModCuentaCobro {

	// Objetos
	CuentaCobro cuentaCobro = new CuentaCobro();
	ConexionCuentaCobro con;

	// Metodos

	// Validar existencia CuentaCobro
	public Boolean existe(String idProveedor, String mes) {
		con = new ConexionCuentaCobro();
		boolean existe = con.existe(idProveedor, mes);
		con.desconectar();
		return existe;

	}

	// Retorna el nombre de CuentaCobro
	public String nombre(String idProveedor, String mes) {
		con = new ConexionCuentaCobro();
		String nombre = con.nombre(idProveedor, mes);
		con.desconectar();
		return nombre;

	}
	
	// Retorna el id de CuentaCobro
		public String id(String idProveedor, String mes) {
			con = new ConexionCuentaCobro();
			String id = con.id(idProveedor, mes);
			con.desconectar();
			return id;

		}

	// Crear nueva Cuenta de Cobro
	public void añadirCuentaCobro(String idProveedor, String mes, String nombre) {
		con = new ConexionCuentaCobro();
		con.nuevaCuentaCobro(idProveedor, mes,nombre);
		con.desconectar();
		

	}

}
