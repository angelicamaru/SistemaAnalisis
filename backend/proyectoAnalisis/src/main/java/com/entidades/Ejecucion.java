package com.entidades;

public class Ejecucion {

	private int idEjecucion;
	private String descripcion;
	private String mes;
	private int idCliente;
	
	
	public Ejecucion() {

	}

	public Ejecucion(int idEjecucion, String descripcion, String mes, int idCliente) {
		this.idEjecucion = idEjecucion;
		this.descripcion = descripcion;
		this.mes = mes;
		this.idCliente = idCliente;
	}
	
	
	public int getIdEjecucion() {
		return idEjecucion;
	}



	public void setIdEjecucion(int idEjecucion) {
		this.idEjecucion = idEjecucion;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getMes() {
		return mes;
	}



	public void setMes(String mes) {
		this.mes = mes;
	}



	public int getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	
}
