package com.entidades;

public class Entregable {

	private int idEntregable;
	private String entregable;
	private double precioProveedor;
	private double precioCliente;
	
	
	
	public Entregable() {
		super();
	}
        
        public Entregable(String entregable, double precioProveedor, double precioCliente) {
		super();
		this.idEntregable = idEntregable;
		this.entregable = entregable;
		this.precioProveedor = precioProveedor;
		this.precioCliente = precioCliente;
	}

	public Entregable(int idEntregable, String entregable, double precioProveedor, double precioCliente) {
		super();
		this.idEntregable = idEntregable;
		this.entregable = entregable;
		this.precioProveedor = precioProveedor;
		this.precioCliente = precioCliente;
	}



	public int getIdEntregable() {
		return idEntregable;
	}



	public void setIdEntregable(int idEntregable) {
		this.idEntregable = idEntregable;
	}



	public String getEntregable() {
		return entregable;
	}



	public void setEntregable(String entregable) {
		this.entregable = entregable;
	}



	public double getPrecioProveedor() {
		return precioProveedor;
	}



	public void setPrecioProveedor(double precioProveedor) {
		this.precioProveedor = precioProveedor;
	}



	public double getPrecioCliente() {
		return precioCliente;
	}



	public void setPrecioCliente(double precioCliente) {
		this.precioCliente = precioCliente;
	}
	
	
	
	
}
