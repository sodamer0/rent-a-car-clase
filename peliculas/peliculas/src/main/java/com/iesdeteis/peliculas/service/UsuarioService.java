package com.iesdeteis.peliculas.service;


import com.iesdeteis.peliculas.model.Usuario;
import com.iesdeteis.peliculas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{

  private UsuarioRepository usuarioRepository;


  @Override
  public List<Usuario> findAll() {
    return (List<Usuario>) usuarioRepository.findAll();
  }

  @Override
  public Usuario findById(Long id) {
    return null;
  }

  @Override
  public void save(String nombre, String mail) {

    Usuario usuario = new Usuario();
    usuario.setNombre(nombre);
    usuario.setEmail(mail);
    usuario.setCreado_en(LocalDate.now().toString());
    usuarioRepository.save(usuario);

  }

  @Override
  public void deleteById(Long id) {

    usuarioRepository.deleteById(id);

  }
}
