package com.crew.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crew.domain.entity.MenuEntity;
import com.crew.repository.coustom.MenuRepositoryCustom;

/**
 * 
 * 클래스명: <code>MenuRepository</code><br/><br/>
 *
 * 설명을 기입하세요
 *
 * @since 2020. 5. 12.
 * @author JaeHan-Kim
 *
 */
public interface MenuRepository extends JpaRepository<MenuEntity, Integer>, MenuRepositoryCustom {

    // List<MenuEntity> findByPreMnuIsNull();

}
