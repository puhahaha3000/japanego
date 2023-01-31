package com.example.japanego.controller;

import com.example.japanego.service.MemberService;
import com.example.japanego.vo.MemberVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class AuthController {

    private final MemberService memberService;

    public AuthController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login_view")
    public String loginView() {
        log.info("loginView()...");
        return "login_view";
    }

    @GetMapping("/sign_up_view")
    public String signUpView() {
        log.info("signUpView()...");
        return "sign_up_view";
    }

    @PostMapping("/sign_up")
    public String signUp(MemberVo memberVo) {
        log.info("signUp()...");
        memberService.insertMember(memberVo);
        return "redirect:/";
    }

    @GetMapping("/password_reset_view")
    public String passwordReset() {
        log.info("passwordReset()...");
        return "password_reset_view";
    }

    @PostMapping("/deleted_account")
    public String deletedAccount() {
        log.info("deletedAccount()...");
        return "deleted_account";
    }
}
