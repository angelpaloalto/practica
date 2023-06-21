package com.bdm.practica.entity;

public class RequestTO {

	private int opcion;
	private int id;
	private String titulo;
	private String genero;
	private int duracion;
	
	public int getOpcion() {
		return opcion;
	}
	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}
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
		builder.append("RequestTO [opcion=");
		builder.append(opcion);
		builder.append(", id=");
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
