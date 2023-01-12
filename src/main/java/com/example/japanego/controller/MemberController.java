package com.example.japanego.controller;

import com.example.japanego.service.AuthInfoService;
import com.example.japanego.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final AuthInfoService authInfoService;

    public MemberController(MemberService memberService, AuthInfoService authInfoService) {
        this.memberService = memberService;
        this.authInfoService = authInfoService;
    }

    @PostMapping("/authenticate")
    public String publishAuthNo(@RequestParam String email, Model model) {
        log.info("authenticate()...");
        int memberNo = memberService.getNo(email);
        authInfoService.publishAuthNo(memberNo, email);

        model.addAttribute("memberNo", memberNo);
        model.addAttribute("email", email);
        return "authenticate";
    }

    @GetMapping("/update_view")
    public String updateView() {
        log.info("updateView()...");
        return "member/update_view";
    }
}
