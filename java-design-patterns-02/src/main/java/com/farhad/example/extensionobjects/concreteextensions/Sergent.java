package com.farhad.example.extensionobjects.concreteextensions;

import com.farhad.example.extensionobjects.abstractextensions.SergentExtension;
import com.farhad.example.extensionobjects.units.SergentUnit;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Getter
@Slf4j
public class Sergent implements SergentExtension {

	private final SergentUnit unit;
	@Override
	public void sergentReady() {
		log.info("[Seergent] {} is ready!", unit.getName());
	}
	
}
