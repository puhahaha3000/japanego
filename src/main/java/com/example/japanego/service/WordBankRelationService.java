package com.example.japanego.service;

import com.example.japanego.vo.MemberWordRelationVo;
import com.example.japanego.vo.WordWordBankRelationVo;

public interface WordBankRelationService {

    void addWordToWordBank(WordWordBankRelationVo wordWordBankRelationVo);
    void removeWordFromWordBank(WordWordBankRelationVo wordWordBankRelationVo);
    void AddMemorizeToMember(MemberWordRelationVo memberWordRelationVo);
    void memorizeRemoveFromMember(MemberWordRelationVo memberWordRelationVo);
}
