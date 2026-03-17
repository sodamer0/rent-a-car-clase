package com.iesdeteis.peliculas.service;

import com.iesdeteis.peliculas.model.Usuario;
import com.iesdeteis.peliculas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

  private final UsuarioRepository usuarioRepository;

  public UsuarioService(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  @Override
  public List<Usuario> findAll() {
    return usuarioRepository.findAll();
  }

  @Override
  public Usuario findById(Long id) {
    return usuarioRepository.findById(id).orElse(null);
  }

  @Override
  public void save(String nombre, String email) {
    Usuario usuario = new Usuario();
    usuario.setNombre(nombre);
    usuario.setEmail(email);
    usuario.setCreado_en(LocalDate.now().toString());
    usuarioRepository.save(usuario);
  }

  @Override
  public void deleteById(Long id) {
    usuarioRepository.deleteById(id);
  }
}