package com.farhad.example.ddd_tips.entities.persons;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class EventLogSupport implements EventLog {

	Map<Class<? extends ChangeEvent>, List<? super ChangeEvent> > changeEvents = new ConcurrentHashMap<>();
	List<NameChangeEvent> history = new ArrayList<>();

	@Override
	public void register(NameChangeEvent nameChangeEvent, String reason) {
		List<? super ChangeEvent> values = changeEvents.compute(NameChangeEvent.class, (k, v) -> v == null ? new ArrayList<>() : v);
		values.add(nameChangeEvent);
	}

	@Override
	public Stream<PersonName> eventOfType(Class<NameChangeEvent> clazz) {
		List<? super ChangeEvent> values = changeEvents.compute(clazz, (k, v) -> v == null ? new ArrayList<>() : v);
		return values.stream().map(t -> ((NameChangeEvent)t).getNewName() );
	}
	
}
