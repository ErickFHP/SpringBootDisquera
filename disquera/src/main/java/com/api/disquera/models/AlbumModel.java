package com.api.disquera.models;

import jakarta.persistence.*;

@Entity
@Table(name = "album")
public class AlbumModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_album;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "fecha_lanzamiento")
    private String fecha_lanzamiento;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "edicion_especial")
    private Boolean edicion_especial;

    @Column(name = "id_artista")
    private Integer id_artista;

    public Integer getId_album() {
        return id_album;
    }

    public void setId_album(Integer id_album) {
        this.id_album = id_album;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }

    public void setFecha_lanzamiento(String fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Boolean getEdicion_especial() {
        return edicion_especial;
    }

    public void setEdicion_especial(Boolean edicion_especial) {
        this.edicion_especial = edicion_especial;
    }

    public Integer getId_artista() {
        return id_artista;
    }

    public void setId_artista(Integer id_artista) {
        this.id_artista = id_artista;
    }
}
