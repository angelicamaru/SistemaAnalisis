package com.spring.logicaNegocio;

import java.util.ArrayList;

import com.entidades.Sponsor;

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

}
