package com.example.japanego.mapper;

import com.example.japanego.vo.MemberWordRelationVo;
import com.example.japanego.vo.WordWordBankRelationVo;

public interface WordBankRelationMapper {

    void insertWord(WordWordBankRelationVo wordWordBankRelationVo);
    void deleteWord(WordWordBankRelationVo wordBankRelationVo);

    void insertMemorize(MemberWordRelationVo memberWordRelationVo);
    void deleteMemorize(MemberWordRelationVo memberWordRelationVo);
}
