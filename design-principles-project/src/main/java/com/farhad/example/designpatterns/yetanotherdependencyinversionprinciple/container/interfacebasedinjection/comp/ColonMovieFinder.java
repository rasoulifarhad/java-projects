package com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple.container.interfacebasedinjection.comp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple.container.interfacebasedinjection.inject.InjectFinder;
import com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple.container.interfacebasedinjection.inject.InjectFinderFileName;
import com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple.container.interfacebasedinjection.inject.Injector;

public class ColonMovieFinder implements MovieFinder, InjectFinderFileName, Injector {

	private String colonDelimitedFileName;

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
		movie.setTitle(parts[0]);
		movie.setDirector(parts[1]);
		return movie;
	}

	@Override
	public void injectFileName(String fileName) {
		this.colonDelimitedFileName = fileName;
	}

	@Override
	public void inject(Object target) {
		((InjectFinder)target).injectFinder(this);
	}

}
