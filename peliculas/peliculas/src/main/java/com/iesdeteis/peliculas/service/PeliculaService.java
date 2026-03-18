package com.iesdeteis.peliculas.service;

import com.iesdeteis.peliculas.model.Pelicula;
import com.iesdeteis.peliculas.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService implements IPeliculaService {

  @Autowired
  private PeliculaRepository peliculaRepository;

  // --- Métodos simples que usa PeliculaController ---

  @Override
  public List<Pelicula> findAll() {
    return peliculaRepository.findAll();
  }

  @Override
  public Pelicula findById(Long id) {
    return peliculaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Pelicula no encontrada con ID: " + id));
  }

  @Override
  public void save(String titulo, Integer anio, String genero) {
    Pelicula pelicula = new Pelicula();
    pelicula.setTitulo(titulo);
    pelicula.setAnio(anio);
    pelicula.setGenero(genero);
    peliculaRepository.save(pelicula);
  }

  @Override
  public void deleteById(Long id) {
    peliculaRepository.deleteById(id);
  }

  // --- Métodos completos que usa UsuarioController ---

  @Override
  public List<Pelicula> getAllPeliculas() {
    return peliculaRepository.findAll();
  }

  @Override
  public Optional<Pelicula> getPeliculaById(Long id) {
    return peliculaRepository.findById(id);
  }

  @Override
  public Pelicula createPelicula(Pelicula pelicula) {
    return peliculaRepository.save(pelicula);
  }

  @Override
  public Optional<Pelicula> updatePelicula(Long id, Pelicula peliculaDetails) {
    return peliculaRepository.findById(id).map(pelicula -> {
      pelicula.setTitulo(peliculaDetails.getTitulo());
      pelicula.setAnio(peliculaDetails.getAnio());
      pelicula.setGenero(peliculaDetails.getGenero());
      return peliculaRepository.save(pelicula);
    });
  }

  @Override
  public boolean deletePelicula(Long id) {
    return peliculaRepository.findById(id).map(pelicula -> {
      peliculaRepository.delete(pelicula);
      return true;
    }).orElse(false);
  }

  @Override
  public List<Pelicula> getPeliculasByGenero(String genero) {
    return peliculaRepository.findByGenero(genero);
  }

  @Override
  public List<Pelicula> getPeliculasByAnio(Integer anio) {
    return peliculaRepository.findByAnio(anio);
  }
}