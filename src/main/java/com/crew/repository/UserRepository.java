package com.crew.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crew.domain.entity.UserEntity;

/**
 * 
 * 클래스명: <code>UserRepository</code><br/><br/>
 *
 * 설명을 기입하세요
 *
 * @since 2020. 5. 6.
 * @author JaeHan-Kim
 *
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
