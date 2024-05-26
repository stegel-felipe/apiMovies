package com.indicadores.filmes;

import com.indicadores.filmes.model.IntervalResponse;
import com.indicadores.filmes.model.Movie;
import com.indicadores.filmes.repository.MovieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MoviesWebServiceApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() throws Exception {
        movieRepository.deleteAll();

        InputStream inputStream = getClass().getResourceAsStream("/data/movielist.csv");
        assert inputStream != null;

        // Load CSV data into the database
        InputStreamReader reader = new InputStreamReader(inputStream);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withDelimiter(';')
                .withFirstRecordAsHeader()
                .parse(reader);
        for (CSVRecord record : records) {
            Movie movie = new Movie();
            movie.setYear(Integer.parseInt(record.get("year")));
            movie.setTitle(record.get("title"));
            movie.setStudios(record.get("studios"));
            movie.setProducers(record.get("producers"));
            movie.setWinner("yes".equalsIgnoreCase(record.get("winner")));
            movieRepository.save(movie);
        }
    }

    @Test
    void testGetProducerWithMaxMinInterval() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/movies/interval"))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        IntervalResponse intervalResponse = objectMapper.readValue(jsonResponse, IntervalResponse.class);

        assertThat(intervalResponse).isNotNull();
        assertThat(intervalResponse.getMin()).isNotEmpty();
        assertThat(intervalResponse.getMax()).isNotEmpty();
    }
}
