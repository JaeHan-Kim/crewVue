package com.crew.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crew.domain.entity.UserEntity;
import com.crew.repository.UserRepository;

/**
 * 
 * 클래스명: <code>UserService</code><br/><br/>
 *
 * 설명을 기입하세요
 *
 * @since 2020. 5. 6.
 * @author JaeHan-Kim
 *
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public List<UserEntity> getUserList() {
        return this.userRepository.findAll();
    }
}
