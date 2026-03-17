package com.iesdeteis.peliculas.service;

import com.iesdeteis.peliculas.model.Pelicula;
import java.util.List;
import java.util.Optional;

public interface IPeliculaService {

  // Obtener todas las películas
  List<Pelicula> getAllPeliculas();

  // Obtener una película por ID
  Optional<Pelicula> getPeliculaById(Long id);

  // Crear una nueva película
  Pelicula createPelicula(Pelicula pelicula);

  // Actualizar una película existente
  Optional<Pelicula> updatePelicula(Long id, Pelicula peliculaDetails);

  // Eliminar una película por ID
  boolean deletePelicula(Long id);

  // Filtrar películas por género
  List<Pelicula> getPeliculasByGenero(String genero);

  // Filtrar películas por año
  List<Pelicula> getPeliculasByAnio(Integer anio);
}