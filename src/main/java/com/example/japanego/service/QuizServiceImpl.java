package com.example.japanego.service;

import com.example.japanego.mapper.QuizMapper;
import com.example.japanego.vo.WordVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class QuizServiceImpl implements QuizService {

    private final QuizMapper quizMapper;

    public QuizServiceImpl(QuizMapper quizMapper) {

        this.quizMapper = quizMapper;
    }

    @Override
    public List<WordVo> quiz(int memberNo) {

        log.info("getWordList() ..");

        return quizMapper.getWordList(memberNo);
    }
}
