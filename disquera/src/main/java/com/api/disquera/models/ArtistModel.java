package com.api.disquera.models;

import jakarta.persistence.*;

@Entity
@Table(name = "artist")
public class ArtistModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_artist;

    @Column(name = "name_artist")
    private String name_artist;

    @Column(name = "country")
    private String country;

    @Column(name = "status_artist")
    private String status_artist;

    public Integer getIdArtist() {
        return id_artist;
    }

    public void setIdArtist(Integer id_artist) {
        this.id_artist = id_artist;
    }

    public String getNameArtist() {
        return name_artist;
    }

    public void setNameArtist(String name_artist) {
        this.name_artist = name_artist;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatusArtist() {
        return status_artist;
    }

    public void setStatusArtist(String status_artist) {
        this.status_artist = status_artist;
    }
}
