package com.farhad.example.ddd_tips.entities.persons;

import java.time.LocalDate;
import java.util.Objects;
import java.util.stream.Stream;

import lombok.Data;
import lombok.Value;

@Data
public class Person {
	private final PersonId personId;
	private final EventLog changeLog;

	private PersonName name;
	private LocalDate birthDate;
	private StreetAddress address;
	private EmailAddress email;
	private PhoneNumber phoneNumber;
	
	public Person(PersonId personId, PersonName name) {
		this.personId = Objects.requireNonNull(personId); 
		Objects.requireNonNull(name);
		this.changeLog = new EventLogSupport();
		changeName(name, "Initial name");
	}


	public void changeName(PersonName name, String reason) {
		this.name = Objects.requireNonNull(name);
		changeLog.register(new NameChangeEvent(name), reason);
		
	}

	public Stream<PersonName> getNameHistory() {
		return this.changeLog.eventOfType(NameChangeEvent.class);
	}

	@Value
	static class PersonId {
		private final Long id;

		public PersonId(Long id) {
			this.id = Objects.requireNonNull(id);
		}

		
	}
}
