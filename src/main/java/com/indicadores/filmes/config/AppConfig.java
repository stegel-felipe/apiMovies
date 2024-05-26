package com.indicadores.filmes.config;

import com.indicadores.filmes.service.MovieService;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
@RequiredArgsConstructor
public class AppConfig {
    private final MovieService movieService;

    @PostConstruct
    public void loadData() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/data/movielist.csv");
            if (inputStream != null) {
                movieService.importMoviesFromCSV(inputStream);
            } else {
                System.err.println("CSV file not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
