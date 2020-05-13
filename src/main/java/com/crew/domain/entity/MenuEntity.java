package com.crew.domain.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "MENU")
@Setter @Getter
public class MenuEntity {
    
    @Id
    @GeneratedValue
    private Integer mnuNo;
    private Integer preMnuNo;
    private String mnuName;
    private int mnuLv;
    private String urlAdr;
    private boolean useYn;
    private LocalDateTime regDate;
    private int regNo;
    private LocalDateTime modDate;
    private int modNo;
    
    
}
