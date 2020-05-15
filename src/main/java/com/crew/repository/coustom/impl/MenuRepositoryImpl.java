package com.crew.repository.coustom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import static com.crew.domain.entity.QMenuEntity.menuEntity;

import com.crew.domain.dto.Menu;
import com.crew.domain.entity.MenuEntity;
import com.crew.repository.BaseRepository;
import com.crew.repository.coustom.MenuRepositoryCustom;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MenuRepositoryImpl extends BaseRepository implements MenuRepositoryCustom {

	public MenuRepositoryImpl() {
        super(MenuEntity.class);
    }

	@Autowired
    private JPAQueryFactory queryFactory;

    @Override
    public List<Menu> findbyctgListAtDsl() {
        Expression<?>[] expr = super.getAllExpression(menuEntity);
        return this.queryFactory
                .select(Projections.bean(Menu.class, expr))
                .from(menuEntity)
                .where(this.queryFactory.selectFrom(menuEntity).where(menuEntity.mnuNo.eq(1)).exists())
                .orderBy(menuEntity.preMnuNo.asc(), menuEntity.dispNo.asc())
                .fetch();
    }
	
}
