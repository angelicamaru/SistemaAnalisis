package com.spring.logicaNegocio;

import java.util.ArrayList;

import com.entidades.Cliente;
import com.entidades.Entregable;
import com.entidades.Proveedor;

import basededatos.ConexionCliente;
import basededatos.ConexionEntregable;
import basededatos.ConexionProveedor;

public class ModEntregable {

	// Objetos
	Entregable entregable = new Entregable();
	ConexionEntregable con;

	// Añadir nuevo entregable
	public void añadirEntregable(Entregable nuevoEntregable) {
		con = new ConexionEntregable();
		con.nuevoEntregable(nuevoEntregable);
		con.desconectar();
	}

	// Retorna el nombres de entregables
	public ArrayList<String> traerNombres() {
		con = new ConexionEntregable();
		ArrayList<String> nombres = con.traerNombres();
		con.desconectar();
		return nombres;

	}
        
        // Retorna la info. de entregables
	public ArrayList<Entregable> traerTodo() {
		con = new ConexionEntregable();
		ArrayList<Entregable> entregables = con.traerTodo();
		con.desconectar();
		return entregables;

	}

	// Retorna el id de entregable
	public int id(String nombre) {
		con = new ConexionEntregable();
		int id = con.id(nombre);
		con.desconectar();
		return id;

	}

	// Mod entregable
	public void mod(Entregable entregableMod) {
		con = new ConexionEntregable();
		con.modE(entregableMod);
		con.desconectar();
		
	}

	// Eliminar entregable
	public void eliminarC(Entregable nombre) {
		con = new ConexionEntregable();
		con.eliminarE(nombre);
		con.desconectar();

	}

}
