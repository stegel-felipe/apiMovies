package com.indicadores.filmes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indicadores.filmes.model.IntervalResponse;
import com.indicadores.filmes.service.MovieService;

@RestController
@RequestMapping("api/movies")
public class MovieController {
	
    private final MovieService movieService;
	
	public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

	 /**
     * Retorna informações sobre o produtor com o maior intervalo entre dois prêmios consecutivos e o produtor que obteve dois prêmios mais rapidamente.
     *
     * @return Um objeto ResponseEntity contendo as informações dos produtores com seus respectivos intervalos.
     */
    
    @GetMapping("/interval")
    public ResponseEntity<IntervalResponse> getProducerWithMaxMinInterval() {
        IntervalResponse intervalResponse = movieService.calculateIntervals();
        return ResponseEntity.ok(intervalResponse);
    }
}
