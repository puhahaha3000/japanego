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

    @Override
    public int getNo(String email) {
        return memberMapper.getNo(email);
    }

    @Override
    public void enableMember(int memberNo) {
        memberMapper.updateEnable(memberNo);
    }

    @Override
    public int updateMember(int no, String password) {
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
        return memberMapper.updateMember(no, encodedPassword);
    }

    @Override
    public void deleteMember(int no) {
        memberMapper.delete(no);
    }

    @Override
    public String searchEmail(String email) {
        int cnt = memberMapper.search(email);
        return String.valueOf(cnt == 0);
    }
}
