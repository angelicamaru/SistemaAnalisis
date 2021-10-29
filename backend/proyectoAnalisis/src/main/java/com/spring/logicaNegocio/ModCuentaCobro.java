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
	public Boolean existe(int idProveedor, String mes) {
		con = new ConexionCuentaCobro();
		boolean existe = con.existe(idProveedor, mes);
		con.desconectar();
		return existe;

	}

	// Retorna el nombre de CuentaCobro
	public String nombre(int idProveedor, String mes) {
		con = new ConexionCuentaCobro();
		String nombre = con.nombre(idProveedor, mes);
		con.desconectar();
		return nombre;

	}

	// Retorna el id de CuentaCobro
	public int id(int idProveedor, String mes) {
		con = new ConexionCuentaCobro();
		int id = con.id(idProveedor, mes);
		con.desconectar();
		return id;

	}

	// Crear nueva Cuenta de Cobro
	public void añadirCuentaCobro(int idProveedor, String mes, String nombre) {
		con = new ConexionCuentaCobro();
		con.nuevaCuentaCobro(idProveedor, mes, nombre);
		con.desconectar();

	}

}
