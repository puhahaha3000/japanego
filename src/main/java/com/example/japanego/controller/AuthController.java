package com.example.japanego.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class AuthController {

    @GetMapping("/login_view")
    public String loginView() {
        log.info("loginView()...");
        return "login_view";
    }

    @GetMapping
    public String index() {
        log.info("index()...");
        return "index";
    }
}
