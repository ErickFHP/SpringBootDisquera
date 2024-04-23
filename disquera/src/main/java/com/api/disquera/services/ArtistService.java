package com.api.disquera.services;

import com.api.disquera.models.ArtistModel;
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
public class ArtistService {
    @Autowired
    IArtistRepositories artistRepositories;


    public ArrayList<ArtistModel> getArtists(){
        return (ArrayList<ArtistModel>) artistRepositories.findAll();
    }

    public ArtistModel saveArtist(ArtistModel artist){
        return artistRepositories.save(artist);
    }

    public ResponseEntity<?> getById(Integer id){
        try {
            Optional<ArtistModel> artistOptional = artistRepositories.findById(id);
            if (artistOptional.isPresent()) {
                ArtistModel artist = artistOptional.get();
                return new ResponseEntity<>(artist, HttpStatus.OK);
            } else {
                Map<String, String> response = new HashMap<>();
                response.put("message", "No encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            Map<String, String> errorBody = new HashMap<>();
            errorBody.put("message", e.getMessage()); // Use exception's message
            return new ResponseEntity<>(errorBody, HttpStatus.OK);
        }

    }


    public ResponseEntity<ArtistModel> updateById(ArtistModel request, Integer id){
        Optional<ArtistModel> artistOptional = artistRepositories.findById(id);
        if (artistOptional.isPresent()) {
            ArtistModel artist = artistOptional.get();
            artist.setNameArtist(request.getNameArtist());
            artist.setCountry(request.getCountry());
            artist.setStatusArtist(request.getStatusArtist());
            artist = artistRepositories.save(artist); // Save the updated artist
            return new ResponseEntity<>(artist, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ArtistModel updateStatusArtistById(Integer id, String status){
        ArtistModel artist = artistRepositories.findById(id).orElse(null);

        // Update the artist's status if the artist is found
        if (artist != null) {
            artist.setStatusArtist(status);
            // Save the updated artist back to the data store
            artistRepositories.save(artist);
            return artist;
        } else {
            return null;
        }
    }
}
