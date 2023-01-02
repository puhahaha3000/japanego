package com.example.japanego.service;

import com.example.japanego.mapper.WordBankMapper;
import com.example.japanego.mapper.WordMapper;
import com.example.japanego.vo.WordBankVo;
import com.example.japanego.vo.WordVo;
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
}
