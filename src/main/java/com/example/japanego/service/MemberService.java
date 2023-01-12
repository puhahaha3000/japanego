package com.example.japanego.service;

import com.example.japanego.vo.MemberVo;

public interface MemberService {
    void insertMember(MemberVo memberVo);

    int getNo(String email);

    void enableMember(int memberNo);
}
