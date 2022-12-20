package com.example.japanego.controller;

import com.example.japanego.service.WordService;
import com.example.japanego.vo.WordVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestfulController {

    final WordService wordService;

    public RestfulController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/first_quiz")
    public List<WordVo> firstQuiz() {
        return wordService.getFirstQuiz();
    }
}
