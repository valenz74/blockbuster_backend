package com.apruebaxtreme.backend.dto;

import com.apruebaxtreme.backend.models.PeliculaCatalogo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeliculaAlquiladaDTOError extends PeliculaAlquiladaDTO{

    private String mensaje;

    public PeliculaAlquiladaDTOError(Long idAlquilada, PeliculaCatalogo peliculaCatalogo) {
        super(idAlquilada, peliculaCatalogo);
        //TODO Auto-generated constructor stub
    }

    public PeliculaAlquiladaDTOError(Long idAlquilada, PeliculaCatalogo peliculaCatalogo, String mensaje){
        super(idAlquilada, peliculaCatalogo);
        this.mensaje = mensaje;
    }
    
}
