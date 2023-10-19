package com.apruebaxtreme.backend.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PeliculaAlquilada {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idAlquilada;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuario usuario;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PeliculaCatalogo peliculaCatalogo;

    public PeliculaAlquilada(Usuario usuario, PeliculaCatalogo peliculaCatalogo) {
        this.usuario = usuario;
        this.peliculaCatalogo = peliculaCatalogo;
    }

}
