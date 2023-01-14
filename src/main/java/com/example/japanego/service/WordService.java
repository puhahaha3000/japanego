package com.example.japanego.service;

import com.example.japanego.vo.WordVo;

import java.util.List;

public interface WordService {
    List<WordVo> getFirstQuiz();

    List<WordVo> getWordList(int startNo,int endNo);

    int getAllWordCount();
}
