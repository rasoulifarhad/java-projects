package com.farhad.example.designpatterns.yetanotherdependencyinversionprinciple.container.interfacebasedinjection.container;

public interface Container {
	public void registerComponnent(String componnentName, Class<?> componnentClazz);
	public void registerInjector(Class<?> injecterClazz,Object object  );

	public void start();
	public Object lookup(String string);
}
