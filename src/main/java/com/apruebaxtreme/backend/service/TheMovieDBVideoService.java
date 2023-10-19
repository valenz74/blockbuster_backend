package com.apruebaxtreme.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apruebaxtreme.backend.dto.MovieResultsDTO;
import com.apruebaxtreme.backend.dto.VideoDTO;
import com.apruebaxtreme.backend.dto.VideosDTO;

@Service
public class TheMovieDBVideoService {

    @Autowired
    RestTemplate restTemplate;


    @Value("${movies.api.key}")
    private String API_KEY;

    public VideoDTO video(Long id) {

        String ENDPOINT_VIDEO = 
        "https://api.themoviedb.org/3/movie/"+id+"/videos?api_key="+API_KEY;

        ResponseEntity<VideosDTO> videos = restTemplate.exchange(
                ENDPOINT_VIDEO, HttpMethod.GET, null,
                VideosDTO.class);

        return videos.getBody().getResults().get(0);
    }
    
}
