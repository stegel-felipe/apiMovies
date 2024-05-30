package com.indicadores.filmes.dto;

import com.indicadores.filmes.model.Movie;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MovieWinnerResponseDTO {

    private Long id;
    private int yearMovie;
    private String title;
    private String studios;
    private String producers;
    private boolean winner;

    public MovieWinnerResponseDTO(Movie data) {
        this.id = data.getId();
        this.yearMovie = data.getYearMovie();
        this.title = data.getTitle();
        this.studios = data.getStudios();
        this.producers = data.getProducers();
        this.winner = data.isWinner();
    }

}
