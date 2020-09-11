package com.crew.web.controller;

import java.util.List;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crew.domain.dto.User;
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
    public List<User> retriveAllUser() {
    	
        
        String field = "user_id";
        String fieldCd = JdbcUtils.convertUnderscoreNameToPropertyName(field);
        String fieldNm = fieldCd.substring(0, fieldCd.length() - 2) + "Nm";

        log.info("{}", field);
        log.info("{}", fieldCd);
        log.info("{}", fieldNm);
        
        //BeanWrapper obj = PropertyAccessorFactory.forBeanPropertyAccess();
        //Object val = obj.getPropertyValue(fieldCd);
        //log.info("{}", val);
        //String name = this.getCodeNm(field, String.valueOf(val));
        //obj.setPropertyValue(fieldNm, name);
    	
        return this.userService.getUserList();
    }
    
    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        log.debug("USER INFO");
        log.debug("{}", user);
    }
    
    @GetMapping("/users/{name}")
    public void alterUser(@PathVariable String name, User user) {
    	log.info("name {}", name);
    	
    	List<User> list = this.userService.getUserByName(name);
    	
    	log.info("user list size {}", list.size());
    }
}
