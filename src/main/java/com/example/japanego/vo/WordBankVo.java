package com.example.japanego.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class WordBankVo {
    private int no;
    private int owner;
    private String name;
    private Date create_date;
    private Date modified_date;
}
