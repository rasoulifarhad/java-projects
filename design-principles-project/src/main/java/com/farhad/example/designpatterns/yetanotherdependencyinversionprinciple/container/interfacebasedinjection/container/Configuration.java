package com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple.container.interfacebasedinjection.container;

public class Configuration {
	
	// private MutablePicoContainer configureContainer() {
	// 	MutablePicoContainer pico = new DefaultPicoContainer();
	// 	Parameter[] finderParams =  {new ConstantParameter("movies1.txt")};
	// 	pico.registerComponentImplementation(MovieFinder.class, ColonMovieFinder.class, finderParams);
	// 	pico.registerComponentImplementation(MovieLister.class);
	// 	return pico;
	// }

	// public void testWithPico() {
	// 	MutablePicoContainer pico = configureContainer();
	// 	MovieLister lister = (MovieLister) pico.getComponentInstance(MovieLister.class);
	// 	Movie[] movies = lister.moviesDirectedBy("Sergio Leone");
	// 	assertEquals("Once Upon a Time in the West", movies[0].getTitle());
	// }
}
