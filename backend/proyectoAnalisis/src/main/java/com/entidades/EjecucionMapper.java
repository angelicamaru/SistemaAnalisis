package com.entidades;

import java.util.ArrayList;

public class EjecucionMapper {

	private int idEjecucion;
	private String descripcion;
	private String mes;
	private int idCliente;
	private String nombreCliente;
	private ArrayList<Solicitud> solicitudes;
	private double total;
	
	
	public EjecucionMapper() {

	}
	
	public EjecucionMapper(String descripcion) {
		this.descripcion = descripcion;
	}

	public EjecucionMapper(String mes, int idCliente) {
		this.mes = mes;
		this.idCliente = idCliente;
	}
	public EjecucionMapper(String mes, String nombreCliente) {
		this.mes = mes;
		this.nombreCliente = nombreCliente;
	}
	
	public EjecucionMapper(String descripcion, String mes, int idCliente) {
		this.descripcion = descripcion;
		this.mes = mes;
		this.idCliente = idCliente;
	}
	
	
	public EjecucionMapper(int idEjecucion, String descripcion, String mes, int idCliente, ArrayList<Solicitud> solicitudes,
			double total) {
		super();
		this.idEjecucion = idEjecucion;
		this.descripcion = descripcion;
		this.mes = mes;
		this.idCliente = idCliente;
		this.solicitudes = solicitudes;
		this.total = total;
	}

	public EjecucionMapper(int idEjecucion, String descripcion, String mes, int idCliente) {
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

	public ArrayList<Solicitud> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	
}
