package com.example.japanego.security;

import com.example.japanego.mapper.MemberMapper;
import com.example.japanego.vo.MemberDetailsVo;
import com.example.japanego.vo.MemberVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberDetailService implements UserDetailsService {

    private final MemberMapper memberMapper;

    public MemberDetailService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.warn("Load User By MemberVo number: " + email);
        MemberVo memberVo = memberMapper.getMember(email);
        log.info(memberVo.toString());
        return new MemberDetailsVo(memberVo);
    }
}
