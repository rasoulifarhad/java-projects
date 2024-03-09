package com.farhad.example.another_bridge.demo3.better;

public class StudentRepository implements BaseRepository {

	private static long id = 0;
	private StorageRepository storageRepository;

	public StudentRepository(StorageRepository storageRepository) {
		this.storageRepository = storageRepository;
	}



	public BaseEntity save(BaseEntity student) {
		student.setId(getNextId());
		storageRepository.store(student);
		return student;		
	}

	private long getNextId() {
		return ++id;
	}


	@Override
	public StorageRepository getRepository() {
		return storageRepository;
	}

}
