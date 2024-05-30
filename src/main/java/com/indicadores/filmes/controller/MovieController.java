package com.indicadores.filmes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indicadores.filmes.dto.ResponseDTO;
import com.indicadores.filmes.service.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

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
    @Operation(summary = "Intervalo de prêmios",
            description = "Retorna informações sobre o produtor com o maior intervalo entre dois prêmios consecutivos e o produtor que obteve dois prêmios mais rapidamente.")
    @ApiResponse(responseCode = "200",
            description = "Retorna a lista de informações dos produtores com seus respectivos intervalos.",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))})
    
    @GetMapping("/interval")
    public ResponseEntity<ResponseDTO> calculateIntervals() {
        return ResponseEntity.ok(movieService.calculateIntervals());
    }
}
