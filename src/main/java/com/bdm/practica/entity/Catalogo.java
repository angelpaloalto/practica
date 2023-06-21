package com.bdm.practica.entity;

import reactor.core.publisher.Flux;

public class Catalogo {
	
	private Flux<Pelicula> lstPeliculas;

	public Flux<Pelicula> getLstPeliculas() {
		return lstPeliculas;
	}

	public void setLstPeliculas(Flux<Pelicula> lstPeliculas) {
		this.lstPeliculas = lstPeliculas;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Catalogo [lstPeliculas=");
		builder.append(lstPeliculas);
		builder.append("]");
		return builder.toString();
	}

}
