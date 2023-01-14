package com.example.japanego.service;

import com.example.japanego.mapper.WordMapper;
import com.example.japanego.vo.WordVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class WordServiceImpl implements WordService {

    private final WordMapper wordMapper;

    WordServiceImpl(WordMapper wordMapper) {
        this.wordMapper = wordMapper;
    }

    @Override
    public List<WordVo> getFirstQuiz() {
        log.info("getFirstQuiz()...");
        ArrayList<WordVo> wordVoArrayList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            wordVoArrayList.addAll(wordMapper.getRandomWord(5, i));
        }
        return wordVoArrayList;
    }

    @Override
    public List<WordVo> getWordList(int startNo,int endNo) {
        log.info("getWordList()...");
        ArrayList<WordVo> wordVoArrayList = new ArrayList<>();
        wordVoArrayList.addAll(wordMapper.getWordList(startNo,endNo));

        return wordVoArrayList;
    }

    @Override
    public int getAllWordCount() {
        log.info("getAllWordCount...");
        return wordMapper.getAllWordCount();
    }

}
