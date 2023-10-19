package com.apruebaxtreme.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apruebaxtreme.backend.dto.VideoDTO;
import com.apruebaxtreme.backend.service.TheMovieDBVideoService;

@RestController
public class TheMovieDBVideoController {

    @Autowired
    TheMovieDBVideoService theMovieDBVideoService;

    @GetMapping("/video")
    public VideoDTO video(@RequestParam Long id){
        return theMovieDBVideoService.video(id);
    }
    
}
