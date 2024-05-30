package com.indicadores.filmes.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

public interface FileMovieService {
    void importMoviesFromCSV() throws IOException;
}
