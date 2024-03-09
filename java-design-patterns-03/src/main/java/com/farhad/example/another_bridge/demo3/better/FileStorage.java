package com.farhad.example.another_bridge.demo3.better;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileStorage implements StorageRepository {

	@Override
	public void store(BaseEntity entity) {
		try {
			FileOutputStream fileOut = new FileOutputStream("filePath");

			ObjectOutputStream oos = new ObjectOutputStream(fileOut);

			oos.writeObject(entity);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
