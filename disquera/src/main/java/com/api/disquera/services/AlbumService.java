package com.api.disquera.services;

import com.api.disquera.models.AlbumModel;
import com.api.disquera.models.ArtistModel;
import com.api.disquera.repositories.IAlbumRepositories;
import com.api.disquera.repositories.IArtistRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AlbumService {
    @Autowired
    IAlbumRepositories albumRepositories;

    @Autowired
    IArtistRepositories artistRepositories;

    public ArrayList<AlbumModel> getAlbums(){
        return (ArrayList<AlbumModel>) albumRepositories.findAll();
    }

    public ResponseEntity<?> saveAlbum(AlbumModel album){
        try {
            if (album == null || album.getTitulo().isEmpty() || album.getFecha_lanzamiento().isEmpty() || album.getPrecio() <= 0 || album.getEdicion_especial() == null) {
                Map<String, String> response = new HashMap<>();
                response.put("message", "Valores inválidos");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            Optional<ArtistModel> artistOptional = artistRepositories.findById(album.getId_artista());
            if (artistOptional.isPresent()) {
                this.albumRepositories.save(album);
                return new ResponseEntity<>(album, HttpStatus.CREATED);
            } else {
                Map<String, String> response = new HashMap<>();
                response.put("message", "Id de artista no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            Map<String, String> errorBody = new HashMap<>();
            errorBody.put("message", e.getMessage());
            return new ResponseEntity<>(errorBody, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> getById(Integer id) {
        try {
            Optional<AlbumModel> albumOptional = albumRepositories.findById(id);
            if (albumOptional.isPresent()) {
                AlbumModel album = albumOptional.get();
                return new ResponseEntity<>(album, HttpStatus.OK);
            } else {
                Map<String, String> response = new HashMap<>();
                response.put("message", "No encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            Map<String, String> errorBody = new HashMap<>();
            errorBody.put("message", e.getMessage());
            return new ResponseEntity<>(errorBody, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<AlbumModel> updateById(AlbumModel request, Integer id){
        Optional<AlbumModel> albumOptional = albumRepositories.findById(id);
        if (albumOptional.isPresent()) {
            AlbumModel album = albumOptional.get();
            album.setTitulo(request.getTitulo());
            album.setPrecio(request.getPrecio());
            album.setEdicion_especial(request.getEdicion_especial());
            album.setFecha_lanzamiento(request.getFecha_lanzamiento());
            album = albumRepositories.save(album); // Save the updated album
            return new ResponseEntity<>(album, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
