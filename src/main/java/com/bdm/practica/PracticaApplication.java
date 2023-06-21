package com.bdm.practica;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bdm.practica.entity.Catalogo;
import com.bdm.practica.entity.Pelicula;

@SpringBootApplication
@EnableTransactionManagement
public class PracticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticaApplication.class, args);
	}
	
//	@Bean
//	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//	public Catalogo catalogo() {
//		return new Catalogo();
//	}
	
//	@Bean
//	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//	public Pelicula pelicula() {
//		return new Pelicula();
//	}

}
