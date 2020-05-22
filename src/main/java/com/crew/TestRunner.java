package com.crew;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.crew.domain.dto.Menu;
import com.crew.service.MenuService;
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

    @Autowired
    private MenuService menuService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // user 정보 입력
        /*
        for (int i = 1; i < 5; i++) {
            User user = new User();
            user.setName("user0" + i);
            
            this.userservice.createUser(user);
        }
        */
        // menu 생성
        Menu rootMenu = new Menu();
        rootMenu.setMnuName("root-1");
        rootMenu.setMnuLv(1);
        rootMenu.setPreMnuNo(0);
        rootMenu.setUseYn(true);
        rootMenu.setDispNo(1);
        rootMenu.setRegDate(LocalDateTime.now());
        rootMenu.setRegNo(1);
        rootMenu.setModDate(LocalDateTime.now());
        rootMenu.setModNo(1);
        Menu rootM = this.menuService.createMenu(rootMenu);
        
        Menu subMenu = new Menu();
        subMenu.setMnuName("root-1 sub-1");
        subMenu.setMnuLv(2);
        subMenu.setPreMnuNo(rootM.getMnuNo());
        subMenu.setUseYn(true);
        subMenu.setDispNo(10);
        subMenu.setRegDate(LocalDateTime.now());
        subMenu.setRegNo(1);
        subMenu.setModDate(LocalDateTime.now());
        subMenu.setModNo(1);
        Menu subM = this.menuService.createMenu(subMenu);
        
        Menu subMenu2 = new Menu();
        subMenu2.setMnuName("root-1 sub-2");
        subMenu2.setMnuLv(2);
        subMenu2.setPreMnuNo(rootM.getMnuNo());
        subMenu2.setUseYn(true);
        subMenu2.setDispNo(20);
        subMenu2.setRegDate(LocalDateTime.now());
        subMenu2.setRegNo(1);
        subMenu2.setModDate(LocalDateTime.now());
        subMenu2.setModNo(1);
        this.menuService.createMenu(subMenu2);
        
        Menu subMenubySub = new Menu();
        subMenubySub.setMnuName("root-1 sub-1 by sub-1");
        subMenubySub.setMnuLv(3);
        subMenubySub.setPreMnuNo(subM.getMnuNo());
        subMenubySub.setUseYn(true);
        subMenubySub.setDispNo(10);
        subMenubySub.setRegDate(LocalDateTime.now());
        subMenubySub.setRegNo(1);
        subMenubySub.setModDate(LocalDateTime.now());
        subMenubySub.setModNo(1);
        
        this.menuService.createMenu(subMenubySub);
        
        Menu subMenubySub2 = new Menu();
        subMenubySub2.setMnuName("root-1 sub-1 by sub-1");
        subMenubySub2.setMnuLv(3);
        subMenubySub2.setPreMnuNo(subM.getMnuNo());
        subMenubySub2.setUseYn(true);
        subMenubySub2.setDispNo(10);
        subMenubySub2.setRegDate(LocalDateTime.now());
        subMenubySub2.setRegNo(1);
        subMenubySub2.setModDate(LocalDateTime.now());
        subMenubySub2.setModNo(1);
        
        this.menuService.createMenu(subMenubySub2);
        
        //List<MenuEntity> rootMenuList = this.menuService.getMenuListParentIsNull();
        //log.info("list size {}", rootMenuList.size());

        /*
        for (MenuEntity me : rootMenuList) {
            log.info("level {} / mnu name {}",me.getMnuLv(), me.getMnuName());
            for (MenuEntity subMnu : me.getChildrenMnu()) {
                log.info("level {} / mnu name {}",subMnu.getMnuLv(), subMnu.getMnuName());
                if (!subMnu.getChildrenMnu().isEmpty()) {
                    log.info("level {} / mnu name {} sub list size {}",subMnu.getMnuLv(), subMnu.getMnuName(), subMnu.getChildrenMnu().size());
                }
            }
        }
        */
    }
}
