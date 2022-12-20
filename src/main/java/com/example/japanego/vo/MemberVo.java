package com.example.japanego.vo;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class MemberVo {
    private int no;
    private String email;
    private String password;
    private Timestamp createDate;
    private Timestamp modifiedDate;
    private String delFlag;
    private String certifyFlag;
    private int grade;

    private List<AuthVo> authVoList;
}
