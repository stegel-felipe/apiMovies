package com.indicadores.filmes.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.indicadores.filmes.model.Interval;
import com.indicadores.filmes.model.IntervalResponse;
import com.indicadores.filmes.model.Movie;
import com.indicadores.filmes.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
	private final MovieRepository movieRepository;

	@Override
	public IntervalResponse calculateIntervals() {
		List<Movie> movies = movieRepository.findAll();

		// Filtra apenas os filmes vencedores
		List<Movie> winners = new ArrayList<>();
		for (Movie movie : movies) {
			if (movie.isWinner()) {
				winners.add(movie);
			}
		}

		// Mapeia produtores aos anos em que ganharam
		Map<String, List<Integer>> producerWins = new HashMap<>();
		for (Movie winner : winners) {
			String[] producers = winner.getProducers().split(", ");
			for (String producer : producers) {
				producerWins.computeIfAbsent(producer, k -> new ArrayList<>()).add(winner.getYear());
			}
		}

		List<Interval> minIntervals = new ArrayList<>();
		List<Interval> maxIntervals = new ArrayList<>();

		// Calcula os intervalos para cada produtor
		for (Map.Entry<String, List<Integer>> entry : producerWins.entrySet()) {
			String producer = entry.getKey();
			List<Integer> years = entry.getValue();
			Collections.sort(years);

			for (int i = 1; i < years.size(); i++) {
				int interval = years.get(i) - years.get(i - 1);
				Interval currentInterval = new Interval(null, producer, interval, years.get(i - 1), years.get(i));

				if (minIntervals.isEmpty() || interval < minIntervals.get(0).getInterval()) {
					minIntervals.clear();
					minIntervals.add(currentInterval);
				} else if (interval == minIntervals.get(0).getInterval()) {
					minIntervals.add(currentInterval);
				}

				if (maxIntervals.isEmpty() || interval > maxIntervals.get(0).getInterval()) {
					maxIntervals.clear();
					maxIntervals.add(currentInterval);
				} else if (interval == maxIntervals.get(0).getInterval()) {
					maxIntervals.add(currentInterval);
				}
			}
		}
		return new IntervalResponse(minIntervals, maxIntervals);
	}

	@Override
	public void importMoviesFromCSV(InputStream inputStream) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader().parse(reader);
			for (CSVRecord record : records) {
				Movie movie = new Movie();
				movie.setYear(Integer.parseInt(record.get("year")));
				movie.setTitle(record.get("title"));
				movie.setStudios(record.get("studios"));
				movie.setProducers(record.get("producers"));
				movie.setWinner("yes".equalsIgnoreCase(record.get("winner")));
				movieRepository.save(movie);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
