package com.example.japanego.service;

import com.example.japanego.mapper.WordMapper;
import com.example.japanego.vo.WordSearchVo;
import com.example.japanego.vo.WordVo;
import com.sun.tools.jconsole.JConsoleContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<WordVo> getWordList(int startNo,int endNo,String search) {
        log.info("getWordList()...");
        ArrayList<WordVo> wordVoArrayList = new ArrayList<>();
        System.out.println(search+": 서치");
        WordSearchVo word = new WordSearchVo();
        word.setWordOption(startNo,endNo,search);
        wordVoArrayList.addAll(wordMapper.getWordList(word));

        return wordVoArrayList;
    }

    @Override
    public int getAllWordCount() {
        log.info("getAllWordCount...");
        return wordMapper.getAllWordCount();
    }

}
