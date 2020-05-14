package com.crew.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crew.domain.dto.Menu;
import com.crew.domain.entity.MenuEntity;
import com.crew.service.MenuService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuservice;
    
    @GetMapping("/menus")
    public List<Menu> getMenuList() {
        
        List<Menu> list = this.menuservice.getMenuListParentIsNull();
        
        
        for (Menu m : list) {
            log.info("!! {}", m.getMnuName());
        }
        
        
        //return this.menuservice.getDispMenuList(list, 1);
        return list;
    }
}
