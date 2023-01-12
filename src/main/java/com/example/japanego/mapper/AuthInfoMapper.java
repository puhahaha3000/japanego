package com.example.japanego.mapper;

import com.example.japanego.vo.AuthInfoVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AuthInfoMapper {
    @Insert("INSERT INTO AUTH_INFO(MEMBER_NO, NO) VALUES(#{memberNo}, #{no})")
    void insertAuthNumber(int memberNo, String no);

    @Select("SELECT * FROM AUTH_INFO WHERE (SYSDATE - CREATE_DATE) * 24 * 60 > #{time}")
    List<AuthInfoVo> checkExpired(int time);

    @Delete("DELETE FROM AUTH_INFO WHERE MEMBER_NO = #{memberNo} AND NO = #{no} AND CREATE_DATE = #{createDate}")
    int delete(AuthInfoVo authInfoVo);

    @Select("SELECT COUNT(*) FROM AUTH_INFO WHERE MEMBER_NO = #{memberNo} AND NO = #{no}")
    int getMemberNoFromAuthNo(int memberNo, String no);

    @Select("SELECT MEMBER_NO FROM AUTH_INFO WHERE NO = #{randomUrl}")
    int getMemberNoFromUrl(String randomUrl);
}
