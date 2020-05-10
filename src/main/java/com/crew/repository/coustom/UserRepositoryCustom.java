package com.crew.repository.coustom;

import java.util.List;

import com.crew.domain.entity.UserEntity;

public interface UserRepositoryCustom {
	List<UserEntity> findbyName(String name);
}
