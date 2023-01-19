package com.example.japanego.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberWordRelationVo {

    private int no;
    private int memberNo;
    private int wordNo;

    public MemberWordRelationVo(int wordNo, int memberNo) {

        this.wordNo = wordNo;
        this.memberNo = memberNo;
    }
}
