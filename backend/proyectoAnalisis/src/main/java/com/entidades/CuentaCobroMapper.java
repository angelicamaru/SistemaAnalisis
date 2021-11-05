package com.entidades;

import java.util.ArrayList;

public class CuentaCobroMapper {

	private int idCuentaCobro;
	private String nombre;
	private String mes;
	private String nombreProveedor;
	private int idProveedor;
	private ArrayList<Solicitud> solicitudes;
	private double total;

	public CuentaCobroMapper() {

	}
	
	public CuentaCobroMapper(int idCuentaCobro) {
		this.idCuentaCobro = idCuentaCobro;
	}

	public CuentaCobroMapper(int idProveedor, String mes) {
		super();
		this.mes = mes;
		this.idProveedor = idProveedor;
	}
	
	public CuentaCobroMapper(String nombreProveedor, String mes) {
		super();
		this.mes = mes;
		this.nombreProveedor = nombreProveedor;
	}
	

	public CuentaCobroMapper(int idCuentaCobro, String nombre, String mes, String nombreProveedor, int idProveedor,
			ArrayList<Solicitud> solicitudes, double total) {
		super();
		this.idCuentaCobro = idCuentaCobro;
		this.nombre = nombre;
		this.mes = mes;
		this.nombreProveedor = nombreProveedor;
		this.idProveedor = idProveedor;
		this.solicitudes = solicitudes;
		this.total = total;
	}

	public CuentaCobroMapper(int idProveedor, String mes, String nombre) {
		this.nombre = nombre;
		this.mes = mes;
		this.idProveedor = idProveedor;
	}

	public CuentaCobroMapper(int idCuentaCobro, String nombre, String mes, int idProveedor) {

		this.idCuentaCobro = idCuentaCobro;
		this.nombre = nombre;
		this.mes = mes;
		this.idProveedor = idProveedor;
	}
	
	

	public CuentaCobroMapper(int idCuentaCobro, String nombre, String mes, int idProveedor,
			ArrayList<Solicitud> solicitudes, double total) {
		
		this.idCuentaCobro = idCuentaCobro;
		this.nombre = nombre;
		this.mes = mes;
		this.idProveedor = idProveedor;
		this.solicitudes = solicitudes;
		this.total = total;
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

	
	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
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

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	
	
	
	

}
