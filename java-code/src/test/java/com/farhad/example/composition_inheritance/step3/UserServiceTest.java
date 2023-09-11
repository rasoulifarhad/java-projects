package com.farhad.example.composition_inheritance.step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	@Spy
	private UserService userService;

	@Test
	public void given_usetTosave_when_newIdSet_then_saved() {
		User user = new User(null, "TestName");
		User expectedUser = new User("newId+User", "TestName");
		doReturn("newId").when(userService).getId();
		when(userRepository.save(expectedUser)).thenReturn(expectedUser);

		User newUser = userService.save(user);

		assertThat(newUser).isEqualTo(expectedUser);
	}

}
