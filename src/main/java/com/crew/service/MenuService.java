package com.crew.service;

import static com.crew.util.ObjectMapperUtils.map;
import static com.crew.util.ObjectMapperUtils.mapList;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crew.domain.dto.Menu;
import com.crew.domain.entity.MenuEntity;
import com.crew.repository.MenuRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public Menu createMenu(Menu menu) {
        
        MenuEntity savedUser = this.menuRepository.save(map(menu, MenuEntity.class));
        
        return map(savedUser, Menu.class);
    }
    
    public List<Menu> getMenuListParentIsNull() {
        
        List<Menu> testList = this.menuRepository.findbyctgListAtDsl();
        
        log.info("test list {}", testList.size());
        
        return getDispMenuList(testList, 1);
    }

    public List<Menu> getDispMenuList(List<Menu> menuList, int preMnuNo) {
        List<Menu> rv = new ArrayList<>();
        
        for (Menu menu : menuList) {
            if (menu.getPreMnuNo() == preMnuNo ) {
                Menu m = new Menu();
                BeanUtils.copyProperties(menu, m);
                
                m.setSubMenu(this.getDispMenuList(menuList, m.getMnuNo()));
                
                rv.add(m);
            }
        }
        
        return rv;
    }
}
