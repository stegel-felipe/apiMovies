package com.indicadores.filmes.config;

import org.springframework.context.annotation.Configuration;

import com.indicadores.filmes.service.FileMovieService;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AppConfig {
    private final FileMovieService fileMovieService;

    @PostConstruct
    public void loadData() throws Exception {
    	fileMovieService.importMoviesFromCSV();
    }
}
