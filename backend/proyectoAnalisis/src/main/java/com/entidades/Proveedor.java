package com.entidades;

public class Proveedor {

	private int idProveedor;
	private String nombre;
	private String telefono;
	private String correo;
	
	
	public Proveedor() {

	}
	
	public Proveedor(int idProveedor, String nombre, String telefono, String correo) {
		this.idProveedor = idProveedor;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
