package com.iesdeteis.peliculas.controller;

import com.iesdeteis.peliculas.model.Pelicula;
import com.iesdeteis.peliculas.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class UsuarioController {

  @Autowired
  private PeliculaService peliculaService;

  // Obtener todas las películas
  @GetMapping
  public ResponseEntity<List<Pelicula>> getAllPeliculas() {
    return new ResponseEntity<>(peliculaService.getAllPeliculas(), HttpStatus.OK);
  }

  // Obtener una película por ID
  @GetMapping("/{id}")
  public ResponseEntity<Pelicula> getPeliculaById(@PathVariable Long id) {
    return peliculaService.getPeliculaById(id)
      .map(pelicula -> new ResponseEntity<>(pelicula, HttpStatus.OK))
      .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  // Crear una nueva película
  @PostMapping
  public ResponseEntity<Pelicula> createPelicula(@RequestBody Pelicula pelicula) {
    return new ResponseEntity<>(peliculaService.createPelicula(pelicula), HttpStatus.CREATED);
  }

  // Actualizar una película existente
  @PutMapping("/{id}")
  public ResponseEntity<Pelicula> updatePelicula(@PathVariable Long id, @RequestBody Pelicula peliculaDetails) {
    return peliculaService.updatePelicula(id, peliculaDetails)
      .map(updatedPelicula -> new ResponseEntity<>(updatedPelicula, HttpStatus.OK))
      .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  // Eliminar una película por ID
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePelicula(@PathVariable Long id) {
    if (peliculaService.deletePelicula(id)) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // Filtrar películas por género
  @GetMapping("/genero/{genero}")
  public ResponseEntity<List<Pelicula>> getPeliculasByGenero(@PathVariable String genero) {
    List<Pelicula> peliculas = peliculaService.getPeliculasByGenero(genero);
    return new ResponseEntity<>(peliculas, HttpStatus.OK);
  }

  // Filtrar películas por año
  @GetMapping("/anio/{anio}")
  public ResponseEntity<List<Pelicula>> getPeliculasByAnio(@PathVariable Integer anio) {
    List<Pelicula> peliculas = peliculaService.getPeliculasByAnio(anio);
    return new ResponseEntity<>(peliculas, HttpStatus.OK);
  }
}