package com.example.japanego.service;

import com.example.japanego.mapper.MemberMapper;
import com.example.japanego.vo.MemberVo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public void insertMember(MemberVo memberVo) {
        memberVo.setPassword(new BCryptPasswordEncoder().encode(memberVo.getPassword()));
        memberMapper.insertMember(memberVo);
        memberMapper.insertAuthorities();
    }
}