package com.example.japanego.controller;

import com.example.japanego.common.util.Paging;
import com.example.japanego.service.AuthInfoService;
import com.example.japanego.service.MemberService;
import com.example.japanego.service.WordService;
import com.example.japanego.vo.WordVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/word")
public class WordRestfulController {
    private final MemberService memberService;
    private final AuthInfoService authInfoService;
    private final WordService wordService;
    private final Paging paging = new Paging();

    public WordRestfulController(MemberService memberService, AuthInfoService authInfoService, WordService wordService) {
        this.memberService = memberService;
        this.authInfoService = authInfoService;
        this.wordService = wordService;
    }

    @GetMapping("/wordList")
    public List<WordVo> wordList(@RequestParam int page,@RequestParam int size,@RequestParam String search){
        log.info("wordList()...");
        paging.setPaging(wordService.getWordTotalCount(), page, size);
        log.info("시작페이지:" + paging.getPageBegin() + ",끝페이지:" + paging.getPageEnd());
        return wordService.getWordList(paging.getPageBegin(),paging.getPageEnd(),search);
    }

    @GetMapping("/wordDetail")
    public List<WordVo> wordDetail(@RequestParam int wordNo){
        log.info("wordDetail()...");
        return  wordService.getWordDetail(wordNo);
    }
}
