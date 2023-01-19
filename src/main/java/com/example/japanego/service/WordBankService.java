package com.example.japanego.service;

import com.example.japanego.vo.MemberWordRelationVo;
import com.example.japanego.vo.WordBankVo;
import com.example.japanego.vo.WordWordBankRelationVo;

import java.util.List;

public interface WordBankService {
    List<WordBankVo> getWordBankList();

}
