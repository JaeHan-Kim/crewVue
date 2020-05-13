package com.crew.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class BaseRepository extends QuerydslRepositorySupport{

    public BaseRepository(Class<?> domainClass) {
        super(domainClass);
    }

}
