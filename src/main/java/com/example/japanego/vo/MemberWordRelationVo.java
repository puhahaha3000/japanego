package com.example.japanego.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberWordRelationVo {

    private int no;
    private int memberNo;
    private int wordNo;

    public MemberWordRelationVo(String wordNo, String memberNo) {

        this.wordNo = Integer.parseInt(wordNo);
        this.memberNo = Integer.parseInt(memberNo);
    }
}
