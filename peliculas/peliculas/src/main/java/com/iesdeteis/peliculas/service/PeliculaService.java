package com.iesdeteis.peliculas.service;

import com.iesdeteis.peliculas.model.Pelicula;
import com.iesdeteis.peliculas.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

  @Autowired
  private PeliculaRepository peliculaRepository;

  public List<Pelicula> getAllPeliculas() {
    return peliculaRepository.findAll();
  }

  public Optional<Pelicula> getPeliculaById(Long id) {
    return peliculaRepository.findById(id);
  }

  public Pelicula createPelicula(Pelicula pelicula) {
    return peliculaRepository.save(pelicula);
  }

  public Optional<Pelicula> updatePelicula(Long id, Pelicula peliculaDetails) {
    return peliculaRepository.findById(id).map(pelicula -> {
      pelicula.setTitulo(peliculaDetails.getTitulo());
      pelicula.setAnio(peliculaDetails.getAnio());
      pelicula.setGenero(peliculaDetails.getGenero());
      return peliculaRepository.save(pelicula);
    });
  }

  public boolean deletePelicula(Long id) {
    return peliculaRepository.findById(id).map(pelicula -> {
      peliculaRepository.delete(pelicula);
      return true;
    }).orElse(false);
  }

  // Filtrar películas por género
  public List<Pelicula> getPeliculasByGenero(String genero) {
    return peliculaRepository.findByGenero(genero);
  }

  // Filtrar películas por año
  public List<Pelicula> getPeliculasByAnio(Integer anio) {
    return peliculaRepository.findByAnio(anio);
  }
}