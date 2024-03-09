package com.farhad.example.another_bridge.demo3;

public class SavecourseInFile {

	public long save() {
		long courseId = nextId();
		checkAccess();
		validateObject();
		setAuditFields();
		openFileToWrite();
		writeDataInFile();
		closeFile();
		return courseId;
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
