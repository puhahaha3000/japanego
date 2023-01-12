package com.example.japanego.controller;

import com.example.japanego.service.AuthInfoService;
import com.example.japanego.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/member")
public class MemberRestController {

    private final MemberService memberService;
    private final AuthInfoService authInfoService;

    public MemberRestController(MemberService memberService, AuthInfoService authInfoService) {
        this.memberService = memberService;
        this.authInfoService = authInfoService;
    }

    @PostMapping("/auth")
    public String auth(@RequestParam int memberNo, @RequestParam String no) {
        log.info("auth()...");
        authInfoService.checkExpired();

        boolean result = authInfoService.auth(memberNo, no);
        if (result) {
            memberService.enableMember(memberNo);
            log.info("Enabled!!!");
        }
        return String.valueOf(result);
    }

    @PostMapping("/update")
    public String update(@RequestParam String password) {
        log.info("update()...");
        String email = ((UserDetails) (SecurityContextHolder.getContext().getAuthentication()).getPrincipal()).getUsername();
        int no = memberService.getNo(email);
        log.info(no + "");
        return String.valueOf(memberService.updateMember(no, password));
    }

    @PostMapping("/send_reset_mail")
    public String sendResetMail(@RequestParam String email) {
        log.info("sendResetMail()...");
        int memberNo = memberService.getNo(email);
        authInfoService.sendResetMail(memberNo, email);
        return "초기화 메일이 발송되었습니다. 메일에 첨부된 링크를 클릭해 주세요";
    }

    @GetMapping("/reset/{randomUrl}")
    public String resetPassword(@PathVariable String randomUrl) {
        log.info("resetPassword()...");
        authInfoService.checkExpired();

        int no = authInfoService.auth(randomUrl);
        String randomPassword = String.valueOf(UUID.randomUUID());

        memberService.updateMember(no, randomPassword);
        return "New Password : " + randomPassword;
    }
}
