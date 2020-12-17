package com.crew.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "MENU")
@Getter
@NoArgsConstructor
public class MenuEntity {

    @Id
    @GeneratedValue
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

}
