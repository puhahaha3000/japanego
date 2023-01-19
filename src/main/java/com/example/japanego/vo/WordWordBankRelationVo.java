package com.example.japanego.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class WordWordBankRelationVo {

    private int no;
    private int wordNo;
    private int wordbankNo;
    private Date createDate;
    private Date modifiedDate;

    public WordWordBankRelationVo(String wordNo, String wordbankNo) {
        this.wordNo = Integer.parseInt(wordNo);
        this.wordbankNo = Integer.parseInt(wordbankNo);
    }
}
