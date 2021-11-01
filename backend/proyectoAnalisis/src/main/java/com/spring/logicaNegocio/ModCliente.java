package com.spring.logicaNegocio;

import java.util.ArrayList;

import com.entidades.Cliente;
import com.entidades.Proveedor;

import basededatos.ConexionCliente;
import basededatos.ConexionProveedor;

public class ModCliente {

	// Objetos
	Cliente cliente = new Cliente();
	ConexionCliente con;

	// Añadir nuevo cliente
	public void añadirCliente(Cliente nuevoCliente) {
		con = new ConexionCliente();
		con.nuevoCliente(nuevoCliente);
		con.desconectar();
	}

	// Retorna el nombres de clientes
	public ArrayList<String> traerNombres() {
		con = new ConexionCliente();
		ArrayList<String> nombres = con.traerNombres();
		con.desconectar();
		return nombres;

	}

	// Retorna el id de cliente
	public int id(String nombre) {
		con = new ConexionCliente();
		int id = con.id(nombre);
		con.desconectar();
		return id;

	}

	// Mod cliente
	public void mod(Cliente clienteMod) {
		con = new ConexionCliente();
		con.modC(clienteMod);
		con.desconectar();
		
	}

	// Eliminar proveedor
	public void eliminarC(Cliente nombre) {
		con = new ConexionCliente();
		con.eliminarC(nombre);
		con.desconectar();

	}

}
