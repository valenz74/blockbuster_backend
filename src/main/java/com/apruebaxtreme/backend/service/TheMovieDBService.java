package com.apruebaxtreme.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apruebaxtreme.backend.dto.MovieResultsDTO;

@Service
public class TheMovieDBService {

    @Autowired
    RestTemplate restTemplate;

    private String END_POINT_SEARCH = "https://api.themoviedb.org/3/search/movie?";
    private String END_POINT_DISCOVER = "https://api.themoviedb.org/3/discover/movie?";

    @Value("${movies.api.key}")
    private String API_KEY;

    public MovieResultsDTO movieResultsDTO(String query) {
        if (query == null) {
            ResponseEntity<MovieResultsDTO> movieResponse = restTemplate
                    .exchange(END_POINT_DISCOVER + "&api_key=" + API_KEY, HttpMethod.GET, null, MovieResultsDTO.class);
            return movieResponse.getBody();
        }

        ResponseEntity<MovieResultsDTO> movieResponse = restTemplate.exchange(
                END_POINT_SEARCH + "&api_key=" + API_KEY + "&query=" + query, HttpMethod.GET, null,
                MovieResultsDTO.class);
        return movieResponse.getBody();
    }

}
