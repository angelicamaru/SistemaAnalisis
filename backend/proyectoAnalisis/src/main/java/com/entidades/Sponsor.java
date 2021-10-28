package com.entidades;

public class Sponsor {

	private int idSponsor;
	private String nombre;
	
	
	public Sponsor() {

	}
	
	public Sponsor(String nombre) {
		this.nombre = nombre;
	}

	public Sponsor(int idSponsor, String nombre) {
		this.idSponsor = idSponsor;
		this.nombre = nombre;
	}

	
	public int getIdSponsor() {
		return idSponsor;
	}

	public void setIdSponsor(int idSponsor) {
		this.idSponsor = idSponsor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
