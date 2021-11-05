package com.spring.logicaNegocio;

import java.util.ArrayList;

import com.entidades.Proveedor;
import com.entidades.Servicio;

import basededatos.ConexionProveedor;
import basededatos.ConexionServicio;

public class ModServicio {

	// Objetos
	Servicio servicio = new Servicio();
	ConexionServicio con;

	// Añadir nuevo Servicio
	public void añadirServicio(Servicio nuevoServicio) {
		con = new ConexionServicio();
		con.nuevoServicio(nuevoServicio);
		con.desconectar();
	}

	// Retorna el nombres de Servicio
	public ArrayList<String> traerNombres() {
		con = new ConexionServicio();
		ArrayList<String> nombres = con.traerNombres();
		con.desconectar();
		return nombres;

	}

	// Retorna el id de Servicio
	public int id(String nombre) {
		con = new ConexionServicio();
		int id = con.id(nombre);
		con.desconectar();
		return id;

	}

	// Mod servicio
	public void mod(Servicio provMod) {
		con = new ConexionServicio();
		con.modS(provMod);
		con.desconectar();

	}

	// Eliminar servicio
	public void eliminarS(Servicio nombre) {
		con = new ConexionServicio();
		con.eliminarS(nombre);
		con.desconectar();

	}

}
