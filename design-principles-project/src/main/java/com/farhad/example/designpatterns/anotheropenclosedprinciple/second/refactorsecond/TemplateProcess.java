package com.farhad.example.designpatterns.anotheropenclosedprinciple.second.refactorsecond;

import com.farhad.example.designpatterns.anotheropenclosedprinciple.TemplateRender;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TemplateProcess {
	private final TemplateRender templateRender;

	public String processTemplate() {
		return null;
	}
}
