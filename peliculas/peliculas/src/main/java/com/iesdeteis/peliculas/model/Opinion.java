package com.iesdeteis.peliculas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "opiniones")
public class Opinion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String comentario;

  private Integer puntuacion;

  @ManyToOne
  @JoinColumn(name = "usuario_id", nullable = false)
  private Usuario usuario;

  @ManyToOne
  @JoinColumn(name = "pelicula_id", nullable = false)
  private Pelicula pelicula;

  // Getters y Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  public Integer getPuntuacion() {
    return puntuacion;
  }

  public void setPuntuacion(Integer puntuacion) {
    this.puntuacion = puntuacion;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public Pelicula getPelicula() {
    return pelicula;
  }

  public void setPelicula(Pelicula pelicula) {
    this.pelicula = pelicula;
  }
}