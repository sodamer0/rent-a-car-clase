package com.iesdeteis.peliculas.repository;

import com.iesdeteis.peliculas.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

  // Filtrar por género
  List<Pelicula> findByGenero(String genero);

  // Filtrar por año
  List<Pelicula> findByAnio(Integer anio);
}