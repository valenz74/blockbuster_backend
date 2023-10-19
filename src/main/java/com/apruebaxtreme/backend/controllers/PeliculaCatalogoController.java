package com.apruebaxtreme.backend.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apruebaxtreme.backend.models.PeliculaCatalogo;
import com.apruebaxtreme.backend.service.PeliculaCatalogoService;

@RestController
public class PeliculaCatalogoController {

    @Autowired
    PeliculaCatalogoService peliculaCatalogoService;

    @GetMapping("/peliculacatalogo")
    public ResponseEntity<List<PeliculaCatalogo>> obtenerPeliculasCatalogo(@RequestParam(required = false) String query){

        if(query==null){
            List<PeliculaCatalogo> listadoTodoCatalogo = peliculaCatalogoService.obtenerPeliculasCatalogo();
            return  ResponseEntity.ok(listadoTodoCatalogo);
        }

        List<PeliculaCatalogo> listadoPeliculas = peliculaCatalogoService.obtenerPeliculasCatalogo(query);
        return ResponseEntity.ok(listadoPeliculas);

    }

    @PostMapping("/peliculacatalogo")
    public ResponseEntity<PeliculaCatalogo> guardarPeliculaCatalogo(@RequestBody PeliculaCatalogo peliculaCatalogo){
        
        PeliculaCatalogo peliculaCatalogoGuardada = peliculaCatalogoService.guardarPeliculaCatalogo(peliculaCatalogo);

        return new ResponseEntity<PeliculaCatalogo>(peliculaCatalogoGuardada, HttpStatus.OK);
    }

    @DeleteMapping("/peliculacatalogo/{idPelicula}")
    public ResponseEntity<HttpStatus> borrarPeliculaCatalogo(@PathVariable Integer idPelicula){
        try {

            peliculaCatalogoService.borrarPeliculasCatalogo(idPelicula);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
            
        } catch (NotFoundException nfe) {
            return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
