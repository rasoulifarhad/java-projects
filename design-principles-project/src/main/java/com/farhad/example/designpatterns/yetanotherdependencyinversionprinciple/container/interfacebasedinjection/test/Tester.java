package com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple.container.interfacebasedinjection.test;

import com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple.container.interfacebasedinjection.boot.BootConfig;
import com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple.container.interfacebasedinjection.comp.Movie;
import com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple.container.interfacebasedinjection.comp.MovieLister;

public class Tester {
	
	public static void main(String[] args) {
		testIface();
	}

	private static void testIface() {
		BootConfig bootConfig = new BootConfig();
		bootConfig.configureContainer();
		MovieLister lister = (MovieLister)bootConfig.getContainer().lookup("MovieLister");
		Movie [] movies = lister.moviesDirectedBy("Sergio Leone");
		System.out.println(movies[0].getTitle());
	}
}
