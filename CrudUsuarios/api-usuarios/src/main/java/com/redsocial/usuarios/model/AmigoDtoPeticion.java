package com.redsocial.usuarios.model;

public class AmigoDtoPeticion {
	private int id;
	private int idUsuarioOrigen;
	private int idUsuarioAmigo;
	
	public AmigoDtoPeticion() {}
	
	public AmigoDtoPeticion(int id, int idUsuarioOrigen, int idUsuarioDestino) {
		this.id = id;
		this.idUsuarioOrigen = idUsuarioOrigen;
		this.idUsuarioAmigo = idUsuarioDestino;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUsuarioOrigen() {
		return idUsuarioOrigen;
	}
	public void setIdUsuarioOrigen(int idUsuarioOrigen) {
		this.idUsuarioOrigen = idUsuarioOrigen;
	}
	public int getIdUsuarioAmigo() {
		return idUsuarioAmigo;
	}
	public void setIdUsuarioAmigoDest(int idUsuarioAmigoDest) {
		this.idUsuarioAmigo = idUsuarioAmigoDest;
	}
}
