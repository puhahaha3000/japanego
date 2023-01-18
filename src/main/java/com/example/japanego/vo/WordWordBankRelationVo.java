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

    /* public WordWordBankRelationVo(int wordNo, int wordbankNo) {
        this.wordNo = wordNo;
        this.wordbankNo = wordbankNo;
    } */
}
