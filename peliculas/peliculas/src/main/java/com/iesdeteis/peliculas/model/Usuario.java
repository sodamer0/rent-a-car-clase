package com.iesdeteis.peliculas.model;

import jakarta.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombre;
  private String email;
  private String creado_en;

  public Usuario() {
  }

  public Usuario(Long id, String nombre, String email, String creado_en) {
    this.id = id;
    this.nombre = nombre;
    this.email = email;
    this.creado_en = creado_en;
  }

  public Usuario(String nombre, String email, String creado_en) {
    this.nombre = nombre;
    this.email = email;
    this.creado_en = creado_en;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCreado_en() {
    return creado_en;
  }

  public void setCreado_en(String creado_en) {
    this.creado_en = creado_en;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
