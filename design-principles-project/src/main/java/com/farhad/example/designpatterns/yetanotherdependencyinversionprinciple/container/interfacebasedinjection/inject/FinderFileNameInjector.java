package com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple.container.interfacebasedinjection.inject;

public class FinderFileNameInjector implements Injector {

	@Override
	public void inject(Object target) {
		((InjectFinderFileName) target).injectFileName("movies.txt");
	}
	
}
