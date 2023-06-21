package com.bdm.practica.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bdm.practica.business.PeliculaComponent;
import com.bdm.practica.business.PeliculasBusiness;
import com.bdm.practica.entity.Pelicula;
import com.bdm.practica.entity.RequestTO;
import com.bdm.practica.entity.ResponseTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/bdm")
public class PeliculasController {
	
	private static final Logger LOG = LoggerFactory.getLogger(PeliculasController.class);
	
	@Autowired
	private PeliculasBusiness business;
	
	@Autowired
	private PeliculaComponent component;
	
	 @ApiOperation(value = "Busqueda de peliculas")
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = ResponseTO.class ),
	            @ApiResponse(code = 400, message = "Bad Request.", response = String.class),
	            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	    @GetMapping("/buscar")
	 public Flux<Pelicula> busquedaPeliculas(){
		 LOG.info("buscando peliculas...");
		 return business.busquedaPeliculas();
	 }
	 
		@ApiOperation(value = "Insertar peliculas")
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = ResponseTO.class),
				@ApiResponse(code = 400, message = "Bad Request.", response = String.class),
				@ApiResponse(code = 500, message = "Error inesperado del sistema") })
		@PostMapping("/guardar")
		public Mono<Pelicula> guardarPeliculas(@RequestBody Pelicula request) {
			LOG.info("Insertando peliculas {}...", request.toString());
			return business.insertarPelicula(request);
		}
		
		@ApiOperation(value = "Carrito facade")
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = ResponseTO.class),
				@ApiResponse(code = 400, message = "Bad Request.", response = String.class),
				@ApiResponse(code = 500, message = "Error inesperado del sistema") })
		@GetMapping("/carrito/facade")
		public Mono<String> manipularCarritoFacade() {
			LOG.info("facade carrito...");
			return business.facadeCarrito();
		}

		@ApiOperation(value = "Manejar carrito")
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = ResponseTO.class),
				@ApiResponse(code = 400, message = "Bad Request.", response = String.class),
				@ApiResponse(code = 500, message = "Error inesperado del sistema") })
		@PostMapping("/carrito")
		public ResponseEntity<Object> manipularCarrito(@RequestBody RequestTO request) {
			LOG.info("llamando carrito...");
			return component.manipularCarrito(request);
		}
		
		@ApiOperation(value = "Ver generos")
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = ResponseTO.class),
				@ApiResponse(code = 400, message = "Bad Request.", response = String.class),
				@ApiResponse(code = 500, message = "Error inesperado del sistema") })
		@GetMapping("/generos")
		public ResponseEntity<Object> verGeneros() {
			LOG.info("buscando generos...");
			return component.generos();
		}
}
