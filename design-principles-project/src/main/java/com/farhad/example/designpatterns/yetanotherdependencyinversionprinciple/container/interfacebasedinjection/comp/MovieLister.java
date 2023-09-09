package com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple.container.interfacebasedinjection.comp;

import java.util.Iterator;
import java.util.List;

import com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple.container.interfacebasedinjection.inject.InjectFinder;

public class MovieLister implements InjectFinder {

	private MovieFinder finder;

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

	@Override
	public void injectFinder(MovieFinder finder) {
		this.finder = finder;
	}

}
