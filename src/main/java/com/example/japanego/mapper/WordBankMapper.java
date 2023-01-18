package com.example.japanego.mapper;

import com.example.japanego.vo.MemberWordRelationVo;
import com.example.japanego.vo.WordVo;
import com.example.japanego.vo.WordWordBankRelationVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WordBankMapper {

    void insertWord(WordWordBankRelationVo wordWordBankRelationVo);
    void deleteWord(WordWordBankRelationVo wordBankRelationVo);

    void insertMemorize(MemberWordRelationVo memberWordRelationVo);
    void deleteMemorize(MemberWordRelationVo memberWordRelationVo);
}
