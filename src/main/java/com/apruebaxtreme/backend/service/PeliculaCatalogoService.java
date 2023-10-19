package com.apruebaxtreme.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.apruebaxtreme.backend.models.PeliculaCatalogo;
import com.apruebaxtreme.backend.repository.PeliculaCatalogoRepository;

@Service
public class PeliculaCatalogoService {

    @Autowired
    PeliculaCatalogoRepository peliculaCatalogoRepository;

    public List<PeliculaCatalogo> obtenerPeliculasCatalogo(){
        return peliculaCatalogoRepository.findAll();
    }

    public List<PeliculaCatalogo> obtenerPeliculasCatalogo(String query){
        return peliculaCatalogoRepository.findByTitleContainingIgnoreCase(query);
    }

    public PeliculaCatalogo guardarPeliculaCatalogo(PeliculaCatalogo peliculaCatalogo){
        return peliculaCatalogoRepository.save(peliculaCatalogo);
    }

    public void borrarPeliculasCatalogo(Integer idPelicula) throws NotFoundException{

        Optional<PeliculaCatalogo> optionalPeliculaCatalogo = peliculaCatalogoRepository.findById(idPelicula);

        optionalPeliculaCatalogo.orElseThrow(()->new NotFoundException());

        peliculaCatalogoRepository.deleteById(idPelicula);

    }
    
}
