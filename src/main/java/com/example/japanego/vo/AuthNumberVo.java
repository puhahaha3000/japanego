package com.example.japanego.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class AuthNumberVo {
    int memberNo;
    String no;
    Timestamp createDate;
}
