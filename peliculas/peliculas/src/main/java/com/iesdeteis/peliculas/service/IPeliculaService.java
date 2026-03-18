package com.iesdeteis.peliculas.service;

import com.iesdeteis.peliculas.model.Pelicula;
import java.util.List;
import java.util.Optional;

public interface IPeliculaService {

  // Métodos que usa PeliculaController
  List<Pelicula> findAll();
  Pelicula findById(Long id);
  void save(String titulo, Integer anio, String genero);
  void deleteById(Long id);

  // Métodos que usa UsuarioController (versión anterior)
  List<Pelicula> getAllPeliculas();
  Optional<Pelicula> getPeliculaById(Long id);
  Pelicula createPelicula(Pelicula pelicula);
  Optional<Pelicula> updatePelicula(Long id, Pelicula peliculaDetails);
  boolean deletePelicula(Long id);
  List<Pelicula> getPeliculasByGenero(String genero);
  List<Pelicula> getPeliculasByAnio(Integer anio);
}