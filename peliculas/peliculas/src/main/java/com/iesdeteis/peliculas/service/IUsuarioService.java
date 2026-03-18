package com.iesdeteis.peliculas.service;

import com.iesdeteis.peliculas.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

  List<Usuario> findAll();

  Usuario findById(Long id);

  void save(String nombre, String email);

  void deleteById(Long id);

	Optional<Usuario> updatedUsuario(Long id, Usuario usuarioDetails);
}