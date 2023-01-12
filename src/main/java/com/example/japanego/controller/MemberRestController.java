package com.example.japanego.controller;

import com.example.japanego.service.AuthNumberService;
import com.example.japanego.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/member")
public class MemberRestController {

    private final MemberService memberService;
    private final AuthNumberService authNumberService;

    public MemberRestController(MemberService memberService, AuthNumberService authNumberService) {
        this.memberService = memberService;
        this.authNumberService = authNumberService;
    }

    @PostMapping("/auth")
    public String auth(@RequestParam int memberNo, @RequestParam String no) {
        log.info("auth()...");
        int sum = authNumberService.checkExpired();
        log.info("Deleted Expired Auth_No : " + sum);

        boolean result = authNumberService.auth(memberNo, no);
        if (result) {
            memberService.enableMember(memberNo);
            log.info("Enabled!!!");
        }
        return String.valueOf(result);
    }
}
