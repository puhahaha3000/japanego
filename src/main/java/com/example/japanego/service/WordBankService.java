package com.example.japanego.service;

import com.example.japanego.vo.MemberWordRelationVo;
import com.example.japanego.vo.WordBankVo;
import com.example.japanego.vo.WordVo;
import com.example.japanego.vo.WordWordBankRelationVo;

import java.util.List;

public interface WordBankService {
    List<WordBankVo> getWordBankList();

    void wordAdd(WordWordBankRelationVo wordWordBankRelationVo);    // 단어를 단어장에 추가하는 서비스
    void wordRemove(WordWordBankRelationVo wordBankRelationVo);     // 단어를 단어장에 삭제하는 서비스
    void memorizeAdd(MemberWordRelationVo memberWordRelationVo);    // 단어를 암기 단어에 추가하는 서비스
    void memorizeRemove(MemberWordRelationVo memberWordRelationVo); // 단어를 암기 단어에 제외하는 서비스
}
