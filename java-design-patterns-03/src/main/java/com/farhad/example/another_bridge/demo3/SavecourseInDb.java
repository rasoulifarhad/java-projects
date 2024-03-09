package com.farhad.example.another_bridge.demo3;

public class SavecourseInDb {

	public long save() {
		long courseId = nextId();
		checkAccess();
		validateObject();
		setAuditFields();
		openDbConnection();
		storeDataInDb();
		closeConnection();
		return courseId;
	}

	private void closeConnection() {
	}

	private void storeDataInDb() {
	}

	private void openDbConnection() {
	}

	private void setAuditFields() {
	}

	private void validateObject() {
	}

	private void checkAccess() {
	}

	private long nextId() {
		return 0;
	}
}
