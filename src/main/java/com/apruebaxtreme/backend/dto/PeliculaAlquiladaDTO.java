package com.apruebaxtreme.backend.dto;

import com.apruebaxtreme.backend.models.PeliculaCatalogo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PeliculaAlquiladaDTO {

    private Long idAlquilada;
    private PeliculaCatalogo peliculaCatalogo;
    
}
