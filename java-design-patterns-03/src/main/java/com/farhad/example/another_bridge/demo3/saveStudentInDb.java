package com.farhad.example.another_bridge.demo3;

public class saveStudentInDb {

	public long save() {
		long studentId = nextId();
		checkAccess();
		validateObject();
		setAuditFields();
		openDbConnection();
		storeDataInDb();
		closeConnection();
		return studentId;
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
