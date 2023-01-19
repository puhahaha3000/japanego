package com.example.japanego.service;

import com.example.japanego.mapper.WordBankRelationMapper;
import com.example.japanego.vo.MemberWordRelationVo;
import com.example.japanego.vo.WordWordBankRelationVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WordBankRelationServiceImpl implements WordBankRelationService {

    private final WordBankRelationMapper wordBankRelationMapper;

    public WordBankRelationServiceImpl(WordBankRelationMapper wordBankRelationMapper) {
        this.wordBankRelationMapper = wordBankRelationMapper;
    }

    @Override
    public void addWordToWordBank(WordWordBankRelationVo wordWordBankRelationVo) {

        log.info("insertWord ..");

        wordBankRelationMapper.insertWord(wordWordBankRelationVo);
    }

    @Override
    public void removeWordFromWordBank(WordWordBankRelationVo wordBWordBankRelationVo) {

        log.info("deleteWord ..");

        wordBankRelationMapper.deleteWord(wordBWordBankRelationVo);
    }

    @Override
    public void AddMemorizeToMember(MemberWordRelationVo memberWordRelationVo) {

        log.info("insertMemorize() ..");

        wordBankRelationMapper.insertMemorize(memberWordRelationVo);
    }

    @Override
    public void memorizeRemoveFromMember(MemberWordRelationVo memberWordRelationVo) {

        log.info("DeleteMemorize() ..");

        wordBankRelationMapper.deleteMemorize(memberWordRelationVo);
    }
}
