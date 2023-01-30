package com.example.japanego.controller;

import com.example.japanego.config.JwtTokenUtil;
import com.example.japanego.security.MemberDetailService;
import com.example.japanego.service.MemberService;
import com.example.japanego.vo.MemberVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
public class AuthController {

    private final MemberService memberService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final MemberDetailService memberDetailService;

    public AuthController(MemberService memberService, AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, MemberDetailService memberDetailService) {
        this.memberService = memberService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.memberDetailService = memberDetailService;
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

    @PostMapping("/login")
    public String createAuthenticationToken(MemberVo memberVo, HttpServletResponse response) throws Exception {
        authenticate(memberVo.getEmail(), memberVo.getPassword());
        final UserDetails userDetails = memberDetailService.loadUserByUsername(memberVo.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);
        response.setHeader("Authorization", token);
        return "index";
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
