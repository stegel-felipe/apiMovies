package com.indicadores.filmes.repository;

import com.indicadores.filmes.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
