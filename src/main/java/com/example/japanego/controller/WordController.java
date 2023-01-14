package com.example.japanego.controller;

import com.example.japanego.common.util.Paging;
import com.example.japanego.service.AuthInfoService;
import com.example.japanego.service.MemberService;
import com.example.japanego.service.WordService;
import com.example.japanego.vo.WordVo;
import com.sun.tools.jconsole.JConsoleContext;
import com.sun.tools.jconsole.JConsolePlugin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/word")
public class WordController {
    private final MemberService memberService;
    private final AuthInfoService authInfoService;
    private final WordService wordService;

    private Paging paging;

    public WordController(MemberService memberService, AuthInfoService authInfoService,WordService wordService) {
        this.memberService = memberService;
        this.authInfoService = authInfoService;
        this.wordService = wordService;
    }

    @GetMapping("/wordList")
    public List<WordVo> wordList(@RequestParam int page,@RequestParam String size,@RequestParam String search){
        log.info("wordList()...");
        int wordCount = wordService.getAllWordCount();

        paging = new Paging(wordCount,page);//이러면 용량 너무 잡아먹지않음..?

        //Paging wordPage = new Paging();?? 어케써야하누.. 전체 페이지 불러와야하는건가..?
        //형식이 형한테 상담받아보자.. 용량 졸라먹을것같은데..


        return wordService.getWordList(paging.getPageBegin(),paging.getPageEnd());
    };
    public void testGitHub(){
        System.out.println("git hub 오류 파악용");
    };
}
