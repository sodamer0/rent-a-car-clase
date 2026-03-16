package com.iesdeteis.peliculas.controller;

import com.iesdeteis.peliculas.model.Usuario;
import com.iesdeteis.peliculas.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
  public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/Usuarios")
    public List<Usuario> getUsuarios(){
      return usuarioService.findAll();
    }

    @GetMapping("/usuarios/{id}")
    public Usuario getUsuarioById(@PathVariable Long id) {
      return usuarioService.findById(id);
    }

    @GetMapping("/usuarios/")
    public void saveUsuario(@RequestParam String nombre, @RequestParam String email) {
      usuarioService.save(nombre, email);
    }

    @GetMapping("/usuarios/delete/{id}")
    public void deleteUsuario(@RequestParam Long id) {
    }

  }



