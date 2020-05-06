package com.crew.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crew.domain.dto.User;
import com.crew.domain.entity.UserEntity;
import com.crew.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 클래스명: <code>UserController</code><br/><br/>
 *
 * 설명을 기입하세요
 *
 * @since 2020. 5. 6.
 * @author JaeHan-Kim
 *
 */

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/users")
    public List<UserEntity> retriveAllUser() {
        return this.userService.getUserList();
    }
    
    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        log.debug("USER INFO");
        log.debug("{}", user);
    }
}
