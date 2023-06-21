package com.bdm.practica.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.bdm.practica.entity.Pelicula;

@Transactional
@Repository
public interface PeliculasRepository extends R2dbcRepository<Pelicula, Long> {

}
