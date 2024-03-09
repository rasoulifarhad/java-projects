package com.farhad.example.another_bridge.demo3;

public class SaveStudentInFile {

	public long save() {
		long studentId = nextId();
		checkAccess();
		validateObject();
		setAuditFields();
		openFileToWrite();
		writeDataInFile();
		closeFile();
		return studentId;
	}

	private void closeFile() {
	}

	private void writeDataInFile() {
	}

	private void openFileToWrite() {
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
