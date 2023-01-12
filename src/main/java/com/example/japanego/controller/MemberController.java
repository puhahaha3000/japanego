package com.example.japanego.controller;

import com.example.japanego.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestParam String email) {
        log.info("authenticate()...");
        int memberNo = memberService.getNo(email);
        memberService.authenticate(memberNo, email);
        return "authenticate";
    }
}
