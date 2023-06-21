package com.bdm.practica.business;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bdm.practica.entity.Pelicula;
import com.bdm.practica.entity.RequestTO;
import com.bdm.practica.entity.ResponseTO;

@Service
public class PeliculaComponent {
	
	@Autowired
	private Carrito carrito;

	public ResponseEntity<Object> manipularCarrito(RequestTO requestTO){
		ResponseTO responseTO = new ResponseTO();
		if(requestTO.getOpcion() == 1) {
			BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beansFactory.xml"));
			Pelicula pelicula = (Pelicula) beanFactory.getBean("pelicula");
			pelicula.setId(requestTO.getId());
			pelicula.setTitulo(requestTO.getTitulo());
			pelicula.setGenero(requestTO.getGenero());
			pelicula.setDuracion(requestTO.getDuracion());
			carrito.agregar(pelicula);
			responseTO.setMensaje("Se agrego la pelicula al carrito");
		}
		else if(requestTO.getOpcion() == 2) {
			carrito.eliminarCarrito();
			responseTO.setMensaje("Se elimino el carrito");
		}
		else {
			responseTO.setMensaje(String.format("carrito: %s", carrito.verCarrito().toString()));
		}
		return ResponseEntity.ok(responseTO);
	}
	
	public ResponseEntity<Object> generos(){
		ResponseTO responseTO = new ResponseTO();
		GeneroPelicula genero1 = new GeneroImp("Terror");
		GeneroPelicula genero2 = new GeneroImp("aventura");
		
		GeneroPelicula pelicula1 = new PeliculaImp("Evil Dead: El Despertar");
		GeneroPelicula pelicula2 = new PeliculaImp("La noche del demonio");
		GeneroPelicula pelicula3 = new PeliculaImp("Super Mario Bros: La Pelicula");
		GeneroPelicula pelicula4 = new PeliculaImp("The Adventure");
		
		genero1.agregar(pelicula1);
		genero1.agregar(pelicula2);
		genero2.agregar(pelicula3);
		genero2.agregar(pelicula4);
		
		GeneroPelicula generos = new GeneroImp("Todos generos");
		generos.agregar(genero1);
		generos.agregar(genero2);
		
		responseTO.setMensaje(String.format("Generos: %s", generos.getPeliculas().toString()));
		
		return ResponseEntity.ok(responseTO);
	}
	
}
