package com.crew.config;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.querydsl.jpa.impl.JPAQueryFactory;

@Configuration
public class QuerydslConfiguration {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Bean
	public JPAQueryFactory jqaQueryFactory() {
		return new JPAQueryFactory(entityManager);
	}
}
