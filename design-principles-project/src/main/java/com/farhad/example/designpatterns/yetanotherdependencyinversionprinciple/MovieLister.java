package com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple;

import java.util.Iterator;
import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class MovieLister {

	private final MovieFinder finder;

	public MovieLister() {
		finder = new ColonDelimitedMovieFinder("movies.txt");
	}

	public Movie [] moviesDirectedBy(String director) {
		List<Movie> allMovies = finder.findAll();
		for (Iterator<Movie> it = allMovies.iterator() ; it.hasNext();) {
			Movie movie = it.next();
			if (!movie.getDirector().equals(director)) {
				it.remove();
			}
		}
		return allMovies.toArray(new Movie [allMovies.size()]);
	}
	
}
