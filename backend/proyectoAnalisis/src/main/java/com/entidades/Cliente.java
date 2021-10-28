package com.entidades;

public class Cliente {

	private int idCliente;
	private String nombre;
	private boolean empresa;
	private String direccion;
	private String telefono;
	private String correo;
	
	public Cliente() {
		
	}

	public Cliente(int idCliente, String nombre, boolean empresa, String direccion, String telefono, String correo) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.empresa = empresa;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isEmpresa() {
		return empresa;
	}

	public void setEmpresa(boolean empresa) {
		this.empresa = empresa;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	
	
	
}
