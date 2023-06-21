package com.bdm.practica.business;

import java.util.List;

public class PeliculaImp implements GeneroPelicula {
	
	private String titulo;
	
	public PeliculaImp(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public void agregar(GeneroPelicula generoPelicula) {
		
	}

	@Override
	public List<GeneroPelicula> getPeliculas() {
		return null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PeliculaImp [titulo=");
		builder.append(titulo);
		builder.append("]");
		return builder.toString();
	}

}
