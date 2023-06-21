package com.bdm.practica.business;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bdm.practica.dao.PeliculasRepository;
import com.bdm.practica.entity.Pelicula;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Transactional
@Component
public class CarritoFacade {
	
	private static final Logger LOG = LoggerFactory.getLogger(CarritoFacade.class);

	@Autowired
	private Carrito carrito;
	@Autowired
	private PeliculasRepository repository;
	
	public Mono<String> agregarCarrito() {
		try {
			Flux<Pelicula> flux = repository.findAll();
			flux.doOnNext(value -> LOG.info("Se encontro la pelicula: {}", value)).subscribe();
			flux.doOnNext(value -> carrito.agregar(value)).subscribe();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Mono.just("Ok").delayElement(Duration.ofSeconds(1));
		
	}
	
}
