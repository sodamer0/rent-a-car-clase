package com.iesdeteis.peliculas.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "peliculas") // Asegúrate de que coincida con el nombre de la tabla en la base de datos
public class Pelicula {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String titulo;

  private Integer anio; // Usamos Integer porque puede ser nulo

  private String genero;

  @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Opinion> opiniones;

  // Getters y Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public Integer getAnio() {
    return anio;
  }

  public void setAnio(Integer anio) {
    this.anio = anio;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public List<Opinion> getOpiniones() {
    return opiniones;
  }

  public void setOpiniones(List<Opinion> opiniones) {
    this.opiniones = opiniones;
  }
}