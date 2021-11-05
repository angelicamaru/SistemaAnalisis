package com.spring.logicaNegocio;

import java.util.ArrayList;

import com.entidades.Proveedor;
import com.entidades.Sponsor;

import basededatos.ConexionProveedor;
import basededatos.ConexionSponsor;

public class ModSponsor {

	// Objetos
	Sponsor sponsor = new Sponsor();
	ConexionSponsor con;

	// Añadir nuevo Sponsor
	public void añadirSponsor(Sponsor nuevoSponsor) {
		con = new ConexionSponsor();
		con.nuevoSponsor(nuevoSponsor);
		con.desconectar();
	}

	// Retorna el nombres de Sponsor
	public ArrayList<String> traerNombres() {
		con = new ConexionSponsor();
		ArrayList<String> nombres = con.traerNombres();
		con.desconectar();
		return nombres;

	}

	// Retorna el id de Sponsor
	public int id(String nombre) {
		con = new ConexionSponsor();
		int id = con.id(nombre);
		con.desconectar();
		return id;

	}

	// Mod sponsor
	public void mod(Sponsor provMod) {
		con = new ConexionSponsor();
		con.modS(provMod);
		con.desconectar();

	}

	// Eliminar sponsor
	public void eliminarS(Sponsor nombre) {
		con = new ConexionSponsor();
		con.eliminarS(nombre);
		con.desconectar();

	}

}
