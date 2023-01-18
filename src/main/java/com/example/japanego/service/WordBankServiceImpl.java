package com.example.japanego.service;

import com.example.japanego.mapper.WordBankMapper;
import com.example.japanego.mapper.WordMapper;
import com.example.japanego.vo.MemberWordRelationVo;
import com.example.japanego.vo.WordBankVo;
import com.example.japanego.vo.WordVo;
import com.example.japanego.vo.WordWordBankRelationVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class WordBankServiceImpl implements WordBankService {

    private final WordBankMapper wordBankMapper;

    WordBankServiceImpl(WordBankMapper wordBankMapper) {
        this.wordBankMapper = wordBankMapper;
    }


	@Override
	public List<WordBankVo> getWordBankList() {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public void wordAdd(WordWordBankRelationVo wordWordBankRelationVo) {

        log.info("insertWord ..");

        wordBankMapper.insertWord(wordWordBankRelationVo);
    }

    @Override
    public void wordRemove(WordWordBankRelationVo wordBankRelationVo) {

        log.info("deleteWord ..");

        wordBankMapper.deleteWord(wordBankRelationVo);
    }

    @Override
    public void memorizeAdd(MemberWordRelationVo memberWordRelationVo) {

        log.info("insertMemorize() ..");

        wordBankMapper.insertMemorize(memberWordRelationVo);
    }

    @Override
    public void memorizeRemove(MemberWordRelationVo memberWordRelationVo) {

        log.info("DeleteMemorize() ..");

        wordBankMapper.deleteMemorize(memberWordRelationVo);
    }
}
