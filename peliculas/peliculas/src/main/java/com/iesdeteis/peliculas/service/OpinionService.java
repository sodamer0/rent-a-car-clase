package com.iesdeteis.peliculas.service;

import com.iesdeteis.peliculas.model.Opinion;
import com.iesdeteis.peliculas.model.Pelicula;
import com.iesdeteis.peliculas.repository.OpinionRepository;
import com.iesdeteis.peliculas.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpinionService implements IOpinionService {

  @Autowired
  private OpinionRepository opinionRepository;

  @Autowired
  private PeliculaRepository peliculaRepository;

  @Override
  public List<Opinion> findAll() {
    return opinionRepository.findAll();
  }

  @Override
  public Opinion findById(Long id) {
    return opinionRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Opinión no encontrada con ID: " + id));
  }

  @Override
  public void save(Integer usuarioId, Long peliculaId, Integer puntuacion, String comentario) {
    Pelicula pelicula = peliculaRepository.findById(peliculaId)
      .orElseThrow(() -> new RuntimeException("Película no encontrada con ID: " + peliculaId));

    Opinion opinion = new Opinion();
    opinion.setUsuarioId(usuarioId);
    opinion.setPelicula(pelicula);
    opinion.setPuntuacion(puntuacion);
    opinion.setComentario(comentario);

    opinionRepository.save(opinion);
  }

  @Override
  public void deleteById(Long id) {
    opinionRepository.deleteById(id);
  }
}