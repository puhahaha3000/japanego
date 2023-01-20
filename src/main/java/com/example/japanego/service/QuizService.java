package com.example.japanego.service;

import com.example.japanego.vo.WordVo;

import java.util.List;

public interface QuizService {

    List<WordVo> quiz(int memberNo);
}
