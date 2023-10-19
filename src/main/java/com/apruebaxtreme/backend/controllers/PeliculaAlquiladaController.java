package com.apruebaxtreme.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apruebaxtreme.backend.dto.IdPeliculaDTO;
import com.apruebaxtreme.backend.dto.PeliculaAlquiladaDTO;
import com.apruebaxtreme.backend.dto.PeliculaAlquiladaDTOError;
import com.apruebaxtreme.backend.exceptions.PeliculaAlquiladaDuplicadaException;
import com.apruebaxtreme.backend.models.PeliculaAlquilada;
import com.apruebaxtreme.backend.service.PeliculaAlquiladaService;

@RestController
public class PeliculaAlquiladaController {

    @Autowired
    PeliculaAlquiladaService peliculaAlquiladaService;

    @GetMapping("/peliculaalquilada")
    public ResponseEntity<List<PeliculaAlquiladaDTO>> obtenerPeliculasAlquiladas(){

        try {
            List<PeliculaAlquiladaDTO> peliculaAlquiladas 
            = peliculaAlquiladaService.obtenerPeliculasAlquiladas();
            return new ResponseEntity<List<PeliculaAlquiladaDTO>>(peliculaAlquiladas, HttpStatus.OK);
        } catch (NotFoundException nfe) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }

    @PostMapping("/peliculaalquilada")
    public ResponseEntity<PeliculaAlquiladaDTO> alquilarPelicula(@RequestBody IdPeliculaDTO idPeliculaDTO){

        try {
            PeliculaAlquiladaDTO peliculaAlquiladaDTO 
            = peliculaAlquiladaService.alquilarPelicula(idPeliculaDTO.getIdPelicula());

            return new ResponseEntity<>(peliculaAlquiladaDTO, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch(PeliculaAlquiladaDuplicadaException pade){

            PeliculaAlquiladaDTOError peliculaAlquiladaDTOError
            =new PeliculaAlquiladaDTOError(null, null, "La película que intentas alquilar ya está en tu base de datos de películas alquiladas");
            return new ResponseEntity<>(peliculaAlquiladaDTOError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
             
    }

    @DeleteMapping("/peliculaalquilada/{idAlquilada}")
    public ResponseEntity<HttpStatus> devolverPelicula(@PathVariable Integer idAlquilada){
        try {
            peliculaAlquiladaService.devolverPelicula(idAlquilada);
            return  new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (NotFoundException nfe) {
            return  new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
        }
    }

    
}
