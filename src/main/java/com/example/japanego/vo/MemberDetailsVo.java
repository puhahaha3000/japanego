package com.example.japanego.vo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
public class MemberDetailsVo implements UserDetails {

    private String email;
    private String password;
    private String certifyFlag;
    private String delFlag;
    private List<GrantedAuthority> authorities;

    public MemberDetailsVo(MemberVo memberVo) {
        setEmail(memberVo.getEmail());
        setPassword(memberVo.getPassword());
        setCertifyFlag(memberVo.getCertifyFlag());
        setDelFlag(memberVo.getDelFlag());
        setAuthorities(memberVo);
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private void setCertifyFlag(String certifyFlag) {
        this.certifyFlag = certifyFlag;
    }

    private void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(MemberVo memberVo) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (AuthVo authVo : memberVo.getAuthVoList()) {
            authorities.add(new SimpleGrantedAuthority(authVo.getAuthority()));
        }

        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return delFlag.equals("0");
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        log.info(String.valueOf(certifyFlag.equals("1")));
        return certifyFlag.equals("1");
    }
}
