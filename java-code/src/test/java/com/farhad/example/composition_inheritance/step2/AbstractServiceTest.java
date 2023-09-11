package com.farhad.example.composition_inheritance.step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AbstractServiceTest {

	@InjectMocks
	@Spy
	private NullObjectAbstractService nullObjectAbstractService;

	@Test
	public void generateId_uuid_generated() {
		UUID uuid = UUID.randomUUID();

		doReturn(uuid).when(nullObjectAbstractService).getUUID();

		String id = nullObjectAbstractService.generateId();

		assertThat(id).isEqualTo(uuid.toString());
	}
}
