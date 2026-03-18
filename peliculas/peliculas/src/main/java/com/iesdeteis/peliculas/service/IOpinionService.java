package com.iesdeteis.peliculas.service;

import com.iesdeteis.peliculas.model.Opinion;
import java.util.List;

public interface IOpinionService {

  // Obtener todas las opiniones
  List<Opinion> findAll();

  // Obtener una opinión por ID
  Opinion findById(Long id);

  void save(Integer usuarioId, Long peliculaId, Integer puntuacion, String comentario);

  // Eliminar una opinión por ID
  void deleteById(Long id);
}