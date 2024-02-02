package com.farhad.example.design_principles02.next_gen_pos_demo.domain.event;

import lombok.Value;

@Value
public class PropertyEvent {

	private Object PropertySource;

	private String PropertyName;

	private Object oldValue;

	private Object newValue;
}
