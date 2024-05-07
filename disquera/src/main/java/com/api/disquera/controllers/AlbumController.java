package com.api.disquera.controllers;

import com.api.disquera.models.AlbumModel;
import com.api.disquera.services.AlbumService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Albums")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @Operation(summary = "Obtener todos los albums")
    @GetMapping
    public ArrayList<AlbumModel> getAlbums() {
        return this.albumService.getAlbums();
    }

    @Operation(summary = "Añadir un objeto album")
    @PostMapping("/add")
    public ResponseEntity<?> saveAlbum (@RequestBody AlbumModel album) {
        return this.albumService.saveAlbum(album);
    }

    @Operation(summary = "Obtener un album por id")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById (@PathVariable("id") Integer id) {
        return this.albumService.getById(id);
    }

    @Operation(summary = "Actualizar album por id")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById (@RequestBody AlbumModel request, @PathVariable("id") Integer id) {
        return this.albumService.updateById(request, id);
    }
}
