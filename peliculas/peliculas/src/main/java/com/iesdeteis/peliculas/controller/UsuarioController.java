package com.iesdeteis.peliculas.controller;

import com.iesdeteis.peliculas.model.Pelicula;
import com.iesdeteis.peliculas.model.Usuario;
import com.iesdeteis.peliculas.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

  @Autowired
  private IUsuarioService usuarioService;

  // Obtener todos los usuarios
  @GetMapping
  public ResponseEntity<List<Usuario>> getAllUsuarios() {
    return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
  }

  // Obtener un usuario por ID
  @GetMapping("/{id}")
  public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
    try {
      Usuario usuario = usuarioService.findById(id);
      return new ResponseEntity<>(usuario, HttpStatus.OK);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  public ResponseEntity<Void> createUsuario(
      @RequestParam String nombre,
      @RequestParam String email) {
    usuarioService.save(nombre, email);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  // Actualizar un usuario existente
  @PutMapping("/{id}")
  public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
    return usuarioService.updatedUsuario(id, usuarioDetails)
      .map(updatedUsuario -> new ResponseEntity<>(updatedUsuario, HttpStatus.OK))
      .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
    usuarioService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }


}