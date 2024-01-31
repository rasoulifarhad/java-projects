package com.farhad.example.design_principles02.grasp.pure_fabrication;

public class Document {

	private String filePath;
	private byte[] content;
	private FileStorage fileStorage;

	public void save() {
		fileStorage.saveFile(filePath, content);
	}

	public byte[] load() {
		return fileStorage.readFile(filePath);
	}
}
