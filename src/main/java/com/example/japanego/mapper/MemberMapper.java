package com.example.japanego.mapper;

import com.example.japanego.vo.MemberVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MemberMapper {
    MemberVo getMember(String email);

    @Insert("INSERT INTO MEMBER(NO, EMAIL, PASSWORD) VALUES (MEMBER_NO_SEQ.nextval, #{email}, #{password})")
    void insertMember(MemberVo memberVo);

    @Insert("INSERT INTO AUTHORITIES(MEMBER_NO) VALUES(MEMBER_NO_SEQ.currval)")
    void insertAuthorities();

    @Select("SELECT NO FROM MEMBER WHERE EMAIL = #{email}")
    int getNo(String email);

    @Update("UPDATE MEMBER SET CERTIFY_FLAG = '1' WHERE NO = #{memberNo}")
    void updateEnable(int memberNo);

    @Update("UPDATE MEMBER SET PASSWORD = #{password} WHERE NO = #{no}")
    int updateMember(int no, String password);
}
