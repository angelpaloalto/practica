package com.bdm.practica.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bdm.practica.dao.PeliculasRepository;
import com.bdm.practica.entity.Catalogo;
import com.bdm.practica.entity.Pelicula;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Transactional
@Service
public class PeliculasBusiness {

	private static final Logger LOG = LoggerFactory.getLogger(PeliculasBusiness.class);
	
	@Autowired
	private PeliculasRepository peliculasRepository;
	
//	@Autowired
//	private Catalogo catalogo;
	
//	@Autowired
//	private Pelicula pelicula;
	
	@Autowired
	private CarritoFacade carritoFacade;
	
	public Flux<Pelicula> busquedaPeliculas(){
		try {
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
			Catalogo catalogo = (Catalogo) applicationContext.getBean("catalogo");
			Flux<Pelicula> result = cargaCatalogo();
			catalogo.setLstPeliculas(result);
//			catalogo.getLstPeliculas().doOnNext(value -> LOG.info("Se encontro la pelicula: {}", value)).subscribe();
			return catalogo.getLstPeliculas();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public Flux<Pelicula> cargaCatalogo(){
		return peliculasRepository.findAll();
	}
	
	public Mono<Pelicula> insertarPelicula(Pelicula request){
		try {
			LOG.info("guardando pelicula...");
			BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beansFactory.xml"));
			Pelicula pelicula = (Pelicula) beanFactory.getBean("pelicula");
			pelicula = request;
			return ingresaPelicula(pelicula);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Mono<Pelicula> ingresaPelicula(Pelicula pelicula){
		return peliculasRepository.save(pelicula);
	}
	
	public Mono<String> facadeCarrito(){
		return carritoFacade.agregarCarrito();
	}
	
}
