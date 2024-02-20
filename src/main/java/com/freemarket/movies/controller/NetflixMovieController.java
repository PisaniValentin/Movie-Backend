package com.freemarket.movies.controller;

import com.freemarket.movies.models.NetflixMovie;
import com.freemarket.movies.services.NetflixMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NetflixMovieController {
    @Autowired
    private NetflixMovieService netflixMovieService;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/suggestTitle/{title}")
    public List<NetflixMovie> getSuggestTitle(@PathVariable String title){
        return netflixMovieService.getSuggestTitle(title);
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/suggestDescription/{description}")
    public List<NetflixMovie> getSuggestDescription(@PathVariable String description){
        return netflixMovieService.getSuggestDescription(description);
    }
}
