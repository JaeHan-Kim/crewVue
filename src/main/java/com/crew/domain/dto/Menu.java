package com.crew.domain.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.crew.domain.entity.MenuEntity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Menu implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 6410739326815389311L;

    private Integer mnuNo;
    private Integer preMnuNo;
    private String mnuName;
    private int mnuLv;
    private String urlAdr;
    private boolean useYn;
    private int dispNo;
    private LocalDateTime regDate;
    private int regNo;
    private LocalDateTime modDate;
    private int modNo;
    
    private List<Menu> subMenu;
}
