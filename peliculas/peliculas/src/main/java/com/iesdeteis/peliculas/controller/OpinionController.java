package com.iesdeteis.peliculas.controller;

import com.iesdeteis.peliculas.model.Opinion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.iesdeteis.peliculas.service.IOpinionService;

import java.util.List;

@RestController
@RequestMapping("/api/opiniones")
public class OpinionController {

  @Autowired
  private IOpinionService opinionService;

  // Obtener todas las opiniones
  @GetMapping
  public ResponseEntity<List<Opinion>> getAllOpiniones() {
    return new ResponseEntity<>(opinionService.findAll(), HttpStatus.OK);
  }

  // Obtener una opinión por ID
  @GetMapping("/{id}")
  public ResponseEntity<Opinion> getOpinionById(@PathVariable Long id) {
    try {
      Opinion opinion = opinionService.findById(id);
      return new ResponseEntity<>(opinion, HttpStatus.OK);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // Crear una nueva opinión
  @PostMapping
  public ResponseEntity<Void> createOpinion(
    @RequestParam Integer usuarioId,
    @RequestParam Long peliculaId,
    @RequestParam Integer puntuacion,
    @RequestParam String comentario) {
    opinionService.save(usuarioId, peliculaId, puntuacion, comentario);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  // Eliminar una opinión por ID
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteOpinion(@PathVariable Long id) {
    opinionService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}