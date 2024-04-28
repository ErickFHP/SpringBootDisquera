package com.api.disquera.controllers;

import com.api.disquera.models.AlbumModel;
import com.api.disquera.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Albums")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @GetMapping
    public ArrayList<AlbumModel> getAlbums() {
        return this.albumService.getAlbums();
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveAlbum (@RequestBody AlbumModel album) {
        return this.albumService.saveAlbum(album);
    }
}
