package com.crew.repository.coustom;

import java.util.List;

import com.crew.domain.dto.Menu;

public interface MenuRepositoryCustom {
    List<Menu> findbyctgListAtDsl();
}
