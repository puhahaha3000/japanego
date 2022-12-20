package com.example.japanego.vo;

import lombok.Data;

@Data
public class WordVo {
    private int no;
    private String word;
    private String hurigana;
    private String okurigana;
    private String yomigana;
    private String mean;
    private int grade;
}
