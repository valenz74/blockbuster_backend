package com.apruebaxtreme.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apruebaxtreme.backend.dto.MovieResultsDTO;
import com.apruebaxtreme.backend.service.TheMovieDBService;

@RestController
public class TheMovieDBController {

    @Autowired
    TheMovieDBService theMovieDBService;

    @GetMapping("/themoviedb")
    public ResponseEntity<MovieResultsDTO> theMovieDB(@RequestParam(required=false) String query){
        MovieResultsDTO movieResultsDTO = theMovieDBService.movieResultsDTO(query);
        return new ResponseEntity<>(movieResultsDTO, HttpStatus.OK);
    }
    
}
