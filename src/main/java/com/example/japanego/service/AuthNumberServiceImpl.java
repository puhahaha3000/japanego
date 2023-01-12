package com.example.japanego.service;

import com.example.japanego.mapper.AuthNumberMapper;
import com.example.japanego.vo.AuthNumberVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Slf4j
@Service
public class AuthNumberServiceImpl implements AuthNumberService {

    private final AuthNumberMapper authNumberMapper;
    private final JavaMailSender javaMailSender;

    public AuthNumberServiceImpl(AuthNumberMapper authNumberMapper, JavaMailSender javaMailSender) {
        this.authNumberMapper = authNumberMapper;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void publishAuthNo(int memberNo, String email) {
        final int LENGTH = 6;
        StringBuilder authenticateStr = new StringBuilder();

        for (int i = 0; i < LENGTH; i++) {
            authenticateStr.append((int) (Math.random() * 10));
        }

        authNumberMapper.insertAuthNumber(memberNo, authenticateStr.toString());

        sendEmail(email, authenticateStr.toString());
    }

    @Override
    public boolean auth(int memberNo, String no) {
        return authNumberMapper.check(memberNo, no) > 0;
    }

    @Override
    public int checkExpired() {
        final int time = 30;
        List<AuthNumberVo> authNumberVoList = authNumberMapper.checkExpired(time);
        int sum = 0;
        for (AuthNumberVo authNumberVo : authNumberVoList) {
            sum += authNumberMapper.delete(authNumberVo);
        }
        return sum;
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
