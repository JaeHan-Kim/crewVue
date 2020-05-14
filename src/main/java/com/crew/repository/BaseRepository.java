package com.crew.repository;

import java.lang.reflect.Field;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

public class BaseRepository extends QuerydslRepositorySupport{

    public BaseRepository(Class<?> domainClass) {
        super(domainClass);
    }

    /**
     * 
     * querydsl의 문자 테이블 select 항목 전체를 구성해서 반환함.
     *
     * @since 2020. 1. 9.
     * @author CREWMATE
     *
     * @param entity
     * @return
     */
    public Expression<?>[] getAllExpression(Object entity, Expression<?>...expressions) {
        Expression<?>[] arr = new Expression[] {};
        Field[] fields = entity.getClass().getDeclaredFields();

        for (Field f : fields) {
            try {
                if (f.getModifiers() == 26) { continue; }

                Expression<?> val = (Expression<?>) f.get(entity);

                if (val instanceof StringPath || val instanceof NumberPath || val instanceof DateTimePath) {
                    arr = (Expression[]) ArrayUtils.add(arr, val);
                }
            } catch (Exception e) {
       //         log.info("skip!");
            }
        }

        // 추가 Expression 적용
        for (Expression<?> e : expressions) {
            arr = (Expression[]) ArrayUtils.add(arr, e);
        }


        return arr;
    }
}
