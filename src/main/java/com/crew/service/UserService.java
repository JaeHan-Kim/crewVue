package com.crew.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crew.domain.dto.User;
import com.crew.domain.entity.UserEntity;
import com.crew.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

import static com.crew.util.ObjectMapperUtils.map;
import static com.crew.util.ObjectMapperUtils.mapList;

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
@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    /**
     * 
     * 회원 목록 조회
    
     * @since 2020. 5. 8.
     * @author JaeHan-Kim
     *
     * @return
     */
    public List<User> getUserList() {
        
        List<User> list = mapList(this.userRepository.findAll(), User.class);
        
        log.info("list size {}", list.size());
        
        return list;
    }
    
    public User createUser(User user) {
        
        UserEntity savedUser = this.userRepository.save(map(user, UserEntity.class));
        
        return map(savedUser, User.class);
    }
}
