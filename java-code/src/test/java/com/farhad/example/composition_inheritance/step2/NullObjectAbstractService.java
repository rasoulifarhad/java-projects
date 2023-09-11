package com.farhad.example.composition_inheritance.step2;

public class NullObjectAbstractService extends AbstractService<User> {

	@Override
	public User save(User t) {
		return null;
	}
	
}
