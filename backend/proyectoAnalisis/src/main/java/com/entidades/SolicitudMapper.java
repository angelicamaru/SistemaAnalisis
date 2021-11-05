package com.entidades;


public class SolicitudMapper {

	
	
	private int cantidad;
	private String nombreCliente;
	private String nombreEjecucion;
	private String nombreEntregable;
	private String fecha;
	private String nombreSolicitud;
	private String nombreServicio;
	private String nombreSponsor;
	private String mes;
	
	
	public SolicitudMapper() {
		super();
	}
	
	public SolicitudMapper(int cantidad, String nombreCliente,String nombreEntregable,
			String fecha, String nombreSolicitud, String nombreServicio, String nombreSponsor) {
		super();
		this.cantidad = cantidad;
		this.nombreCliente = nombreCliente;
		this.nombreEntregable = nombreEntregable;
		this.fecha = fecha;
		this.nombreSolicitud = nombreSolicitud;
		this.nombreServicio = nombreServicio;
		this.nombreSponsor = nombreSponsor;
	}
	

	public SolicitudMapper(int cantidad, String nombreCliente, String nombreEjecucion, String nombreEntregable,
			String fecha, String nombreSolicitud, String nombreServicio, String nombreSponsor) {
		super();
		this.cantidad = cantidad;
		this.nombreCliente = nombreCliente;
		this.nombreEjecucion = nombreEjecucion;
		this.nombreEntregable = nombreEntregable;
		this.fecha = fecha;
		this.nombreSolicitud = nombreSolicitud;
		this.nombreServicio = nombreServicio;
		this.nombreSponsor = nombreSponsor;
	}
	public SolicitudMapper(int cantidad, String nombreCliente, String nombreEjecucion, String nombreEntregable,
			String fecha, String nombreSolicitud, String nombreServicio, String nombreSponsor, String mes) {
		super();
		this.cantidad = cantidad;
		this.nombreCliente = nombreCliente;
		this.nombreEjecucion = nombreEjecucion;
		this.nombreEntregable = nombreEntregable;
		this.fecha = fecha;
		this.nombreSolicitud = nombreSolicitud;
		this.nombreServicio = nombreServicio;
		this.nombreSponsor = nombreSponsor;
		this.mes = mes;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNombreEjecucion() {
		return nombreEjecucion;
	}

	public void setNombreEjecucion(String nombreEjecucion) {
		this.nombreEjecucion = nombreEjecucion;
	}

	public String getNombreEntregable() {
		return nombreEntregable;
	}

	public void setNombreEntregable(String nombreEntregable) {
		this.nombreEntregable = nombreEntregable;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNombreSolicitud() {
		return nombreSolicitud;
	}

	public void setNombreSolicitud(String nombreSolicitud) {
		this.nombreSolicitud = nombreSolicitud;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public String getNombreSponsor() {
		return nombreSponsor;
	}

	public void setNombreSponsor(String nombreSponsor) {
		this.nombreSponsor = nombreSponsor;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}
	
	
	
	
}

