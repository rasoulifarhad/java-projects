package com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ColonDelimitedMovieFinder implements MovieFinder {

	private final String colonDelimitedFileName;

	@Override
	public List<Movie> findAll() {
		return extractMovies();
	}

	private List<Movie> extractMovies() {
		List<Movie> allMovies = new ArrayList<>();
		try {
			List<String> lines = Files.readAllLines(Paths.get(colonDelimitedFileName));
			for (String line : lines) {
				final Movie movie = transformToMovie(line);
				allMovies.add(movie);
			}
		} catch (IOException e) {
			throw new RuntimeException("error: ", e);
		}
		return allMovies;
	}

	private Movie transformToMovie(String line) {
		String [] parts = line.split(":");
		if(parts == null || parts.length != 2) {
			throw new RuntimeException("each line must be 2 field ");
		}
		Movie movie = new Movie();
		movie.setName(parts[0]);
		movie.setDirector(parts[1]);
		return movie;
	}
	
}
