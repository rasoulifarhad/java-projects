package com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple.container.interfacebasedinjection.boot;

import com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple.container.interfacebasedinjection.comp.ColonMovieFinder;
import com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple.container.interfacebasedinjection.comp.MovieLister;
import com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple.container.interfacebasedinjection.container.Container;
import com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple.container.interfacebasedinjection.inject.FinderFileNameInjector;
import com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple.container.interfacebasedinjection.inject.InjectFinder;
import com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple.container.interfacebasedinjection.inject.InjectFinderFileName;

import lombok.Getter;


public class BootConfig {
	
	@Getter
	private Container container;

	public void configureContainer() {
		registerComponents();
		registerInjectors();
		container.start();

	}

	private void registerInjectors() {
		container.registerInjector(InjectFinder.class, container.lookup("MovieFinder"));
		container.registerInjector(InjectFinderFileName.class, new FinderFileNameInjector());
	}

	private void registerComponents() {
		container.registerComponnent("MovieLister", MovieLister.class);
		container.registerComponnent("MovieFinder", ColonMovieFinder.class);
	}
}
