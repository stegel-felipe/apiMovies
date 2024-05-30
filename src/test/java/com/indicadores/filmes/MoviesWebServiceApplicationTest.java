package com.indicadores.filmes;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.indicadores.filmes.dto.ResponseDTO;
import com.indicadores.filmes.service.MovieService;

@SpringBootTest
@AutoConfigureMockMvc
public class MoviesWebServiceApplicationTest {

    @Autowired
    private MovieService movieService;

    /**
     * Testa o cálculo dos intervalos de prêmios usando o serviço MovieService.
     * Verifica se os intervalos mínimos e máximos esperados são encontrados no resultado.
     */
    @Test
    public void testCalculateIntervals() {
        // Calcula os intervalos de prêmios
        ResponseDTO responseDto = movieService.calculateIntervals();

        // Verifica se o intervalo mínimo (1) e o intervalo máximo (13) estão presentes no resultado.
        boolean minIntervalFound = responseDto.getMin().stream()
                .anyMatch(producerResponseDto -> producerResponseDto.getInterval() == 1);

        boolean maxIntervalFound = responseDto.getMax().stream()
                .anyMatch(producerResponseDto -> producerResponseDto.getInterval() == 13);

        // Asserções para verificar se os intervalos foram encontrados no resultado.
        assertTrue(minIntervalFound, "Expected minimum interval of 1 was not found.");
        assertTrue(maxIntervalFound, "Expected maximum interval of 13 was not found.");
    }
}
