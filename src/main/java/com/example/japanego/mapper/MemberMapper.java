package com.example.japanego.mapper;

import com.example.japanego.vo.MemberVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {
    MemberVo getMember(String email);

    @Insert("INSERT INTO MEMBER(NO, EMAIL, PASSWORD) VALUES (MEMBER_NO_SEQ.nextval, #{email}, #{password})")
    void insertMember(MemberVo memberVo);

    @Insert("INSERT INTO AUTHORITIES(MEMBER_NO) VALUES(MEMBER_NO_SEQ.currval)")
    void insertAuthorities();

    @Select("SELECT NO FROM MEMBER WHERE EMAIL = #{email}")
    int getNo(String email);

    @Insert("INSERT INTO AUTH_NUMBER(MEMBER_NO, NO) VALUES(#{memberNo}, #{no})")
    void insertAuthNumber(int memberNo, String no);
}
