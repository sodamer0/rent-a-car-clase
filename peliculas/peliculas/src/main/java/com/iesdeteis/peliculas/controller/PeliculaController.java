package com.iesdeteis.peliculas.controller;

import com.iesdeteis.peliculas.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.iesdeteis.peliculas.service.IPeliculaService;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

  @Autowired
  private IPeliculaService peliculaService;

  // Obtener todas las películas
  @GetMapping
  public ResponseEntity<List<Pelicula>> getAllPeliculas() {
    return new ResponseEntity<>(peliculaService.findAll(), HttpStatus.OK);
  }

  // Obtener una película por ID
  @GetMapping("/{id}")
  public ResponseEntity<Pelicula> getPeliculaById(@PathVariable Long id) {
    try {
      Pelicula pelicula = peliculaService.findById(id);
      return new ResponseEntity<>(pelicula, HttpStatus.OK);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // Crear una nueva película
  @PostMapping
  public ResponseEntity<Void> createPelicula(
    @RequestParam String titulo,
    @RequestParam Integer anio,
    @RequestParam String genero) {
    peliculaService.save(titulo, anio, genero);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  // Eliminar una película por ID
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePelicula(@PathVariable Long id) {
    peliculaService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}