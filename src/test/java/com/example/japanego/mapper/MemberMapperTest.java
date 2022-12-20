package com.example.japanego.mapper;

import com.example.japanego.vo.MemberVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    void getMember() {
        MemberVo memberVo = memberMapper.getMember("test@test.com");
        System.out.println(memberVo);
    }
}