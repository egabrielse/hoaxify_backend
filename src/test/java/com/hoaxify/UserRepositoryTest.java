package com.hoaxify;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import com.hoaxify.user.User;
import com.hoaxify.user.UserRepository;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {
	
	@Autowired
	TestEntityManager testEntityManager;
	
	@Autowired
	UserRepository userRepository;
	
	private User createValidUser() {
		User user = new User();
	
		user.setUsername("test-user");
		user.setDisplayName("test-displayName");
		user.setPassword("test-p4ssWord");
		return user;
	}

	
	@Test
	public void findByUsername_whenUserExists_returnsUser() {
		 User user = createValidUser();
		 testEntityManager.persist(user);
		 User inDB = userRepository.findByUsername(user.getUsername());
		 assertThat(inDB).isNotNull();
	}
	
	@Test
	public void findByUsername_whenUserExists_returnsMatchingUser() {
		 User user = createValidUser();
		 testEntityManager.persist(user);
		 User inDB = userRepository.findByUsername(user.getUsername());
		 assertThat(inDB).isEqualTo(user);
	}
	
	@Test
	public void findByUsername_whenUserDoesNotExist_returnsNull() {
		 User inDB = userRepository.findByUsername("nonexistantUser");
		 assertThat(inDB).isNull();
	}
}
