package com.api.disquera.repositories;

import com.api.disquera.models.ArtistModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArtistRepositories extends JpaRepository<ArtistModel, Integer> {

}
