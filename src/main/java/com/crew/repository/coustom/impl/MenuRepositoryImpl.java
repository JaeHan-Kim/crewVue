package com.crew.repository.coustom.impl;

import java.util.List;

import static com.crew.domain.entity.QMenuEntity.menuEntity;

import com.crew.domain.dto.Menu;
import com.crew.domain.entity.MenuEntity;
import com.crew.repository.coustom.MenuRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MenuRepositoryImpl implements MenuRepositoryCustom {

	private final JPAQueryFactory queryFactory;

    @Override
    public List<Menu> findbyctgListAtDsl() {
        
        return this.queryFactory
                .select(Projections.bean(Menu.class))
                .from(menuEntity)
                .orderBy(menuEntity.preMnuNo.asc()).fetch();
    }
	
}
