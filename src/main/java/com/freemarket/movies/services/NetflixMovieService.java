package com.freemarket.movies.services;

import com.freemarket.movies.models.NetflixMovie;
import com.freemarket.movies.repositories.NetflixMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NetflixMovieService {

    @Autowired
    private NetflixMovieRepository netflixMovieRepository;

    public List<NetflixMovie> getSuggestTitle(String title){
        return netflixMovieRepository.findByTitle(title);
    }

    public List<NetflixMovie> getSuggestDescription(String description){
        return netflixMovieRepository.findByDescription(description);
    }
}
