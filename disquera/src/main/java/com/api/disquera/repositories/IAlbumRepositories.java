package com.api.disquera.repositories;

import com.api.disquera.models.AlbumModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlbumRepositories extends JpaRepository<AlbumModel, Integer> {

}
