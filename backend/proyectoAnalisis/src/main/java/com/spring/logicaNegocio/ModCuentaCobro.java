package com.spring.logicaNegocio;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.entidades.CuentaCobro;
import com.entidades.Solicitud;

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

	//Traer cuenta de cobro
	public CuentaCobro cuentaCobro(int idProveedor, String mes) {
		con = new ConexionCuentaCobro();
		
		ModSolicitud solicitud = new ModSolicitud();
		
		int id = con.id(idProveedor, mes);
		String nombre = con.nombre(idProveedor, mes);
		
		ArrayList<Solicitud> solicitudes = solicitud.traerSolicitudes(id);	
		
		
		CuentaCobro cuenta = new CuentaCobro(id,nombre,mes, idProveedor,solicitudes,total());
		con.desconectar();
		return cuenta;
	}
	
	//Total solicitudes
	
	public double total() {
		double precioTotal = 3000;
		
		return precioTotal;
	}

}
