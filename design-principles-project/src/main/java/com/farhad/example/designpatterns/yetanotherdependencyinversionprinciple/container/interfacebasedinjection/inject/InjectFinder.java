package com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple.container.interfacebasedinjection.inject;

import com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple.container.interfacebasedinjection.comp.MovieFinder;

public interface InjectFinder {
	void injectFinder(MovieFinder finder);
}
