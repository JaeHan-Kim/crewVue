package com.crew.service;

import static com.crew.util.ObjectMapperUtils.map;
import static com.crew.util.ObjectMapperUtils.mapList;

import java.util.List;

import javax.transaction.Transactional;

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
    
    @Transactional
    public List<Menu> getMenuListParentIsNull() {
        
        //List<MenuEntity> list = this.menuRepository.findByPreMnuIsNull();
        /*
        for (MenuEntity me : list) {
            recursiveTree(me);
        }
        */
        
        List<Menu> testList = this.menuRepository.findbyctgListAtDsl();
        
        log.info("test list {}", testList.size());
        
        // return mapList(list, Menu.class);
        
        return null;
    }
    /*
    private void recursiveTree(MenuEntity me) {
        if (me.getChildrenMnu().size() > 0) {
            for (MenuEntity m : me.getChildrenMnu()) {
                recursiveTree(m);
            }
        }
    }
    */
}
