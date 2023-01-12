package com.example.japanego.service;

import com.example.japanego.mapper.MemberMapper;
import com.example.japanego.vo.MemberVo;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MemberServiceImpl implements MemberService {

    private final JavaMailSender javaMailSender;
    private final MemberMapper memberMapper;

    MemberServiceImpl(MemberMapper memberMapper, JavaMailSender javaMailSender) {
        this.memberMapper = memberMapper;
        this.javaMailSender = javaMailSender;
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
    public void authenticate(int memberNo, String email) {
        final int LENGTH = 6;
        StringBuilder authenticateStr = new StringBuilder();

        for (int i = 0; i < LENGTH; i++) {
            authenticateStr.append((int) (Math.random() * 10));
        }

        memberMapper.insertAuthNumber(memberNo, authenticateStr.toString());

        sendEmail(email, authenticateStr.toString());
    }

    private void sendEmail(String email, String authenticateStr) {
        String subject = "Japanego Account Authenticate Mail";
        String text = "인증번호 : " + authenticateStr;

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(text);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
