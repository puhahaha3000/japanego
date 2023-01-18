package com.example.japanego.service;

import com.example.japanego.vo.MemberWordRelationVo;
import com.example.japanego.vo.WordBankVo;
import com.example.japanego.vo.WordVo;
import com.example.japanego.vo.WordWordBankRelationVo;

import java.util.List;

public interface WordBankService {
    List<WordBankVo> getWordBankList();

    void wordAdd(WordWordBankRelationVo wordWordBankRelationVo);
    void wordRemove(WordWordBankRelationVo wordBankRelationVo);
    void memorizeAdd(MemberWordRelationVo memberWordRelationVo);
    void memorizeRemove(MemberWordRelationVo memberWordRelationVo);
}
