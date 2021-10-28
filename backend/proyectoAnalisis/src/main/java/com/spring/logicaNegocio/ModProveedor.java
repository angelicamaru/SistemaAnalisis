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
	public String id(String nombre) {
		con = new ConexionProveedor();
		String id = con.id(nombre);
		con.desconectar();
		return id;

	}

}
