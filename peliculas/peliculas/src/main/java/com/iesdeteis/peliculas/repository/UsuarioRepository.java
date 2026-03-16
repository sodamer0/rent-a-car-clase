package com.iesdeteis.peliculas.repository;

import com.iesdeteis.peliculas.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

  public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

  }

