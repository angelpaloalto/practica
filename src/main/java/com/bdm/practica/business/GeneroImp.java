package com.bdm.practica.business;

import java.util.ArrayList;
import java.util.List;

public class GeneroImp implements GeneroPelicula {
	
	private String nombre;
	private List<GeneroPelicula> peliculas;
	
	public GeneroImp(String nombre) {
		this.nombre = nombre;
		this.peliculas = new ArrayList<>();
	}
	
	@Override
	public void agregar(GeneroPelicula generoPelicula) {
		peliculas.add(generoPelicula);
	}

	@Override
	public List<GeneroPelicula> getPeliculas() {
		return peliculas;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GeneroImp [nombre=");
		builder.append(nombre);
		builder.append(", peliculas=");
		builder.append(peliculas);
		builder.append("]");
		return builder.toString();
	}
	
}
