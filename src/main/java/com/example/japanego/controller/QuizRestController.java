package com.example.japanego.controller;

import com.example.japanego.service.QuizService;
import com.example.japanego.vo.WordVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/quiz")
public class QuizRestController {

    private final QuizService quizService;

    public QuizRestController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("")
    public List<WordVo> quiz(@RequestParam("memberNo") String userNo) {

        log.info("quiz() ..");

        int memberNo = Integer.parseInt(userNo);

        // int memberNo = 2;   // test code

        List<WordVo> quizList = quizService.quiz(memberNo);

        return quizList;
    }

}
