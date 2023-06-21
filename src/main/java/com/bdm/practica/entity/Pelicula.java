package com.bdm.practica.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pelicula")
public class Pelicula {

	@Id
	private int id;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "genero")
	private String genero;
	@Column(name = "duracion")
	private int duracion;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pelicula [id=");
		builder.append(id);
		builder.append(", titulo=");
		builder.append(titulo);
		builder.append(", genero=");
		builder.append(genero);
		builder.append(", duracion=");
		builder.append(duracion);
		builder.append("]");
		return builder.toString();
	}
	
}
