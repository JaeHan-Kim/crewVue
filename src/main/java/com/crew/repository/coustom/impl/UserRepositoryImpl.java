package com.crew.repository.coustom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import static com.crew.domain.entity.QUserEntity.userEntity;
import com.crew.domain.entity.UserEntity;
import com.crew.repository.coustom.UserRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class UserRepositoryImpl implements UserRepositoryCustom {

	@Autowired
	private JPAQueryFactory queryFactory;
	
	@Override
	public List<UserEntity> findbyName(String name) {
		return queryFactory
				.selectFrom(userEntity)
				.where(userEntity.name.eq(name))
				.fetch();
	}

}
