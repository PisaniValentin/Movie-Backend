package com.freemarket.market.controller;

import com.freemarket.market.models.NetflixMovie;
import com.freemarket.market.services.NetflixMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NetflixMovieController {
    @Autowired
    private NetflixMovieService netflixMovieService;

    @GetMapping("/suggestTitle/{title}")
    public List<NetflixMovie> getSuggestTitle(@PathVariable String title){
        return netflixMovieService.getSuggestTitle(title);
    }

    @GetMapping("/suggestDescription/{description}")
    public List<NetflixMovie> getSuggestDescription(@PathVariable String description){
        return netflixMovieService.getSuggestDescription(description);
    }
}
