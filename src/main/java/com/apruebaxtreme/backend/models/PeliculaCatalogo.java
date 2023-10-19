package com.apruebaxtreme.backend.models;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PeliculaCatalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPelicula;

    private String poster_path;
    private String title;
    private LocalDate release_date;
    private String original_language;
    private Float vote_average;
    private String backdrop_path;
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String overview;

    public PeliculaCatalogo(String poster_path, String title, LocalDate release_date, String original_language,
            Float vote_average, String overview, String backdrop_path, Long id) {
        this.poster_path = poster_path;
        this.title = title;
        this.release_date = release_date;
        this.original_language = original_language;
        this.vote_average = vote_average;
        this.overview = overview;
        this.backdrop_path=backdrop_path;
        this.id=id;
    }

}
