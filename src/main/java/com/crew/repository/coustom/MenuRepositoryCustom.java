package com.crew.repository.coustom;

import java.util.List;

import com.crew.domain.dto.Menu;
import com.crew.domain.entity.MenuEntity;


public interface MenuRepositoryCustom {
    List<Menu> findbyctgListAtDsl();
}
