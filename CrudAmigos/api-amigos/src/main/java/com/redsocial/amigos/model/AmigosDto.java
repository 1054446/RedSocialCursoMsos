package com.redsocial.amigos.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "amigos", schema = "public")
public class AmigosDto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable=false)
	private int id;
    @Column(name = "idusuarioorigen")	
    private int idUsuarioOrigen;
    @Column(name = "idusuarioamigo")	
    private int idUsuarioAmigo;
	
	public AmigosDto() {
	}

	public AmigosDto(int idUsuarioOrigen, int idUsuarioAmigo) {
		super();
		this.idUsuarioOrigen = idUsuarioOrigen;
		this.idUsuarioAmigo = idUsuarioAmigo;
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

	public void setIdUsuarioAmigo(int idUsuarioAmigo) {
		this.idUsuarioAmigo = idUsuarioAmigo;
	}

}
