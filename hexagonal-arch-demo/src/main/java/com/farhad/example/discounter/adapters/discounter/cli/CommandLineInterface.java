package com.farhad.example.discounter.adapters.discounter.cli;

import com.farhad.example.discounter.adapters.Driver;
import com.farhad.example.discounter.application.ports.Discounter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommandLineInterface implements Driver {

	private final Discounter discounterApp;
	
	@Override
	public void run(String... args) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'run'");
	}
	 
}
