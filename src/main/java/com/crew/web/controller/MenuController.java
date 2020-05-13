package com.crew.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crew.domain.dto.Menu;
import com.crew.domain.entity.MenuEntity;
import com.crew.service.MenuService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuservice;
    
    @GetMapping("/menus")
    public List<Menu> getMenuList() {
        return this.menuservice.getMenuListParentIsNull();
        
    }
}
