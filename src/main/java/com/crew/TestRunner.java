package com.crew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.crew.domain.dto.User;
import com.crew.service.UserService;

/**
 * 
 * 클래스명: <code>TestRunner</code><br/><br/>
 *
 * 임시 데이터 생성용 Runner
 *
 * @since 2020. 5. 8.
 * @author JaeHan-Kim
 *
 */
@Component
public class TestRunner implements ApplicationRunner {

    @Autowired
    private UserService userservice;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 1; i < 5; i++) {
            User user = new User();
            user.setName("user0" + i);
            
            this.userservice.createUser(user);
        }
    }

}
