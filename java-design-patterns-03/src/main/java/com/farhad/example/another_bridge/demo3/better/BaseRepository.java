package com.farhad.example.another_bridge.demo3.better;

public interface BaseRepository {


	BaseEntity save(BaseEntity entity);

	StorageRepository getRepository();


}
