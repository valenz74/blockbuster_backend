package com.apruebaxtreme.backend.dto;

import java.util.List;

import com.apruebaxtreme.backend.models.PeliculaCatalogo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MovieResultsDTO {

    private List<PeliculaCatalogo> results;
    
}
