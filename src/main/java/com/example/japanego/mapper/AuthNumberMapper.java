package com.example.japanego.mapper;

import com.example.japanego.vo.AuthNumberVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AuthNumberMapper {
    @Insert("INSERT INTO AUTH_NUMBER(MEMBER_NO, NO) VALUES(#{memberNo}, #{no})")
    void insertAuthNumber(int memberNo, String no);

    @Select("SELECT * FROM AUTH_NUMBER WHERE (SYSDATE - CREATE_DATE) * 24 * 60 > #{time}")
    List<AuthNumberVo> checkExpired(int time);

    @Delete("DELETE FROM AUTH_NUMBER WHERE MEMBER_NO = #{memberNo} AND NO = #{no} AND CREATE_DATE = #{createDate}")
    int delete(AuthNumberVo authNumberVo);

    @Select("SELECT COUNT(*) FROM AUTH_NUMBER WHERE MEMBER_NO = #{memberNo} AND NO = #{no}")
    int check(int memberNo, String no);
}
