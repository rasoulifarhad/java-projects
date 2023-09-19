package com.farhad.example.ddd_tips.entities.persons;

import java.util.stream.Stream;

public interface EventLog {

	void register(NameChangeEvent nameChangeEvent, String reason);

	Stream<PersonName> eventOfType(Class<NameChangeEvent> class1);
	
}
