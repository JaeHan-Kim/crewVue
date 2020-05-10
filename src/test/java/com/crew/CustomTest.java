package com.crew;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.crew.domain.entity.UserEntity;
import com.crew.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class CustomTest {

	@Autowired
	private UserRepository userRepository;
	
	@AfterEach
	public void tearDown() throws Exception {
		log.info("test end");
		this.userRepository.deleteAllInBatch();
	}
	
	@Test
	@DisplayName("query dsl 동작 확인.")
	public void testQueryDSLConfig() {
		String name = "jaehan";
		UserEntity u = new UserEntity();
		u.setName(name);
		
		this.userRepository.save(u);
		
		List<UserEntity> result = this.userRepository.findbyName(name);
		
		Assertions.assertEquals(result.size(), 1);
	}
}
