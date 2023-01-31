package com.example.japanego.controller;

import com.example.japanego.config.JwtTokenUtil;
import com.example.japanego.security.MemberDetailService;
import com.example.japanego.vo.JwtResponse;
import com.example.japanego.vo.MemberVo;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthRestController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final MemberDetailService memberDetailService;

    public AuthRestController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, MemberDetailService memberDetailService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.memberDetailService = memberDetailService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(MemberVo memberVo) throws Exception {
        authenticate(memberVo.getEmail(), memberVo.getPassword());
        final UserDetails userDetails = memberDetailService.loadUserByUsername(memberVo.getEmail());
        final String jwtToken = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(jwtToken));
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
