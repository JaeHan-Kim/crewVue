package com.crew.domain.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 클래스명: <code>User</code><br/><br/>
 *
 * 설명을 기입하세요
 *
 * @since 2020. 5. 6.
 * @author JaeHan-Kim
 *
 */
@Setter @Getter
public class User implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -6850673270826231829L;

    private Long id;
    
    private String name;
    
}
