package com.example.japanego.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberWordRelationVo {

    private int no;
    private int memberNo;
    private int wordNo;

    /* public MemberWordRelationVo(int memberNo, int wordNo) {
        this.memberNo = memberNo;
        this.wordNo = wordNo;
    } */
}
