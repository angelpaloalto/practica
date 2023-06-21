package com.bdm.practica.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.bdm.practica.entity.Pelicula;

@Component
@SessionScope
public class Carrito {
	
	private List<Pelicula> lstPeliculas;
	
	public Carrito() {
		lstPeliculas = new ArrayList<>();
	}

	public void agregar(Pelicula pelicula) {
		lstPeliculas.add(pelicula);
	}
	
	public void eliminarCarrito() {
		lstPeliculas.clear();
	}
	
	public List<Pelicula> verCarrito(){
		return lstPeliculas;
	}
}
