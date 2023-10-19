package com.apruebaxtreme.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apruebaxtreme.backend.models.PeliculaAlquilada;
import com.apruebaxtreme.backend.models.PeliculaCatalogo;

public interface PeliculaCatalogoRepository extends JpaRepository<PeliculaCatalogo, Integer>{
    
    List<PeliculaCatalogo> findByTitleContainingIgnoreCase(String query);

    List<PeliculaCatalogo> findByIdPelicula(Integer idPelicula);

}
