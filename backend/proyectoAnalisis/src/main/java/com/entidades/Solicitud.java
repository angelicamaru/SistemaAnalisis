package com.entidades;


public class Solicitud {

	private int idSolicitud;
	private String nombre;
	private int cantidad;
	private String fecha;
	private int idEntregable;
	private int idEjecucion;
	private int idSponsor;
	private int idService; 
	private int idCuentaCobro;
	
	
	
	public Solicitud() {
	}


	public Solicitud( String nombre, int cantidad, String fecha) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}

	public Solicitud(int idSolicitud, String nombre, int cantidad, String fecha) {
		this.idSolicitud = idSolicitud;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}

	public Solicitud( String nombre, int cantidad, String fecha, int idEntregable, int idEjecucion, int idSponsor,
			int idService,int idCuentaCobro) {
	
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.idEntregable =idEntregable;
		this.idEjecucion = idEjecucion;
		this.idSponsor = idSponsor;
		this.idService = idService;
		this.idCuentaCobro = idCuentaCobro;
	}
	public Solicitud(int idSolicitud, String nombre, int cantidad, String fecha, int idEntregable, int idEjecucion, int idSponsor,
			int idService,int idCuentaCobro) {
	
		this.idSolicitud = idSolicitud;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.idEntregable =idEntregable;
		this.idEjecucion = idEjecucion;
		this.idSponsor = idSponsor;
		this.idService = idService;
		this.idCuentaCobro = idCuentaCobro;
	}

	
	
	//Getters and setters

	
	public int getIdSolicitud() {
		return idSolicitud;
	}


	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getFecha() {
		return fecha;
	}


	public int getIdEntregable() {
		return idEntregable;
	}


	public void setIdEntregable(int idEntregable) {
		this.idEntregable = idEntregable;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	


	public int getIdEjecucion() {
		return idEjecucion;
	}


	public void setIdEjecucion(int idEjecucion) {
		this.idEjecucion = idEjecucion;
	}


	public int getIdSponsor() {
		return idSponsor;
	}


	public void setIdSponsor(int idSponsor) {
		this.idSponsor = idSponsor;
	}


	public int getIdService() {
		return idService;
	}


	public void setIdService(int idService) {
		this.idService = idService;
	}
	
	public int getIdCuentaCobro() {
		return idCuentaCobro;
	}


	public void setIdCuentaCobro(int idCuentaCobro) {
		this.idCuentaCobro = idCuentaCobro;
	}
	
	
	
	
	
}

