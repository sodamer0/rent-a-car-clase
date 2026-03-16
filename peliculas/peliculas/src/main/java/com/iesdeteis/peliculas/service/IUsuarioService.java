package com.iesdeteis.peliculas.service;

import com.iesdeteis.peliculas.model.Usuario;

import java.util.List;

public interface IUsuarioService {

  public List<Usuario> findAll();
  public Usuario findById(Long id);
  public void save(String nombre, String mail);
  public void deleteById(Long id);





}
