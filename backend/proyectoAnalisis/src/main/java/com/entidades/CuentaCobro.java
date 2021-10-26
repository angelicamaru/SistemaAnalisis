package com.entidades;

public class CuentaCobro {

	private int idCuentaCobro;
	private String nombre;
	private String mes;
	private int idProveedor;
	
	
	public CuentaCobro() {
		
	}


	public CuentaCobro(int idCuentaCobro, String nombre, String mes, int idProveedor) {

		this.idCuentaCobro = idCuentaCobro;
		this.nombre = nombre;
		this.mes = mes;
		this.idProveedor = idProveedor;
	}


	public int getIdCuentaCobro() {
		return idCuentaCobro;
	}


	public void setIdCuentaCobro(int idCuentaCobro) {
		this.idCuentaCobro = idCuentaCobro;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getmes() {
		return mes;
	}


	public void setmes(String mes) {
		this.mes = mes;
	}


	public int getIdProveedor() {
		return idProveedor;
	}


	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	
	
	
	
}
