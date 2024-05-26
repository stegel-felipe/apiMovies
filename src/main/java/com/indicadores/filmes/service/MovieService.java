package com.indicadores.filmes.service;

import java.io.InputStream;

import com.indicadores.filmes.model.IntervalResponse;

public interface MovieService {
	IntervalResponse calculateIntervals();
    void importMoviesFromCSV(InputStream inputStream);
}
