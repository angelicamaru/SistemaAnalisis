package com.spring.logicaNegocio;

import java.util.ArrayList;

import com.entidades.Cliente;
import com.entidades.Proveedor;

import basededatos.ConexionCliente;
import basededatos.ConexionProveedor;

public class ModProveedor {

	// Objetos
	Proveedor proveedor = new Proveedor();
	ConexionProveedor con;

	// Añadir nuevo proveedor
	public void añadirProveedor(Proveedor nuevoProveedor) {
		con = new ConexionProveedor();
		con.nuevoProveedor(nuevoProveedor);
		con.desconectar();
	}

	// Retorna el nombres de proveedor
	public ArrayList<String> traerNombres() {
		con = new ConexionProveedor();
		ArrayList<String> nombres = con.traerNombres();
		con.desconectar();
		return nombres;

	}

	// Retorna el id de proveedor
	public int id(String nombre) {
		con = new ConexionProveedor();
		int id = con.id(nombre);
		con.desconectar();
		return id;

	}

	// Mod proveedor
	public void mod(Proveedor provMod) {
		con = new ConexionProveedor();
		con.modP(provMod);
		con.desconectar();

	}

	// Eliminar proveedor
	public void eliminarP(Proveedor nombre) {
		con = new ConexionProveedor();
		con.eliminarP(nombre);
		con.desconectar();

	}

}
