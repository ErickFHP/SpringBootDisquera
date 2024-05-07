package com.api.disquera.controllers;

import com.api.disquera.models.ArtistModel;
import com.api.disquera.services.ArtistService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.swagger.v3.oas.annotations.Operation;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/Artists")
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @Operation(summary = "Obtener todos los artistas")
    @GetMapping
    public ArrayList<ArtistModel> getArtists(){
        return this.artistService.getArtists();
    }

    @Operation(summary = "Guardar un objeto artista")
    @PostMapping("/add")
    public ResponseEntity<ArtistModel> saveArtist(@RequestBody ArtistModel artist){
        ArtistModel savedArtist = artistService.saveArtist(artist);
        return new ResponseEntity<>(savedArtist, HttpStatus.CREATED);
    }

    @Operation(summary = "Obtener un artista por ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> getArtistById(@PathVariable("id") Integer id){
        return this.artistService.getById(id);
    }

    @Operation(summary = "Actualizar un artista por ID")
    @PutMapping("/update/{id}")
    public ResponseEntity<ArtistModel> updateArtistById(@RequestBody ArtistModel request, @PathVariable("id") Integer id){
        return this.artistService.updateById(request, id);
    }

    @Operation(summary = "Actualizar estatus de artista por ID")
    @PatchMapping("/update/status/{id}")
    public ResponseEntity<ArtistModel> updateArtistStatusById(@PathVariable("id") Integer id, @RequestBody Map<String, String> statusArtist) {
        ArtistModel updatedArtist = this.artistService.updateStatusArtistById(id, statusArtist.get("statusArtist"));
        if (updatedArtist != null) {
            return ResponseEntity.ok(updatedArtist);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
