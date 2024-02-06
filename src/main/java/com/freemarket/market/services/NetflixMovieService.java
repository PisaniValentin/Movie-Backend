package com.freemarket.market.services;

import com.freemarket.market.models.NetflixMovie;
import com.freemarket.market.repositories.NetflixMovieRepository;
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
