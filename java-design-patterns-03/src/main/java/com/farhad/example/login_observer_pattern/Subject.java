package com.farhad.example.login_observer_pattern;

import java.time.Instant;

public interface Subject {

	void registerObserver(Observer observer);

	void notifyAllObservers(String userName, String userType, Instant time);

	String getUserName();

	String getUserType();

	Instant getLoginDate();
}
