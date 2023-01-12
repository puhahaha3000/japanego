package com.example.japanego.service;

import com.example.japanego.mapper.AuthInfoMapper;
import com.example.japanego.vo.AuthInfoVo;
import com.example.japanego.vo.EmailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class AuthInfoServiceImpl implements AuthInfoService {

    private final AuthInfoMapper authInfoMapper;
    private final JavaMailSender javaMailSender;

    public AuthInfoServiceImpl(AuthInfoMapper authInfoMapper, JavaMailSender javaMailSender) {
        this.authInfoMapper = authInfoMapper;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void publishAuthNo(int memberNo, String email) {
        final int LENGTH = 6;
        StringBuilder authenticateStr = new StringBuilder();

        for (int i = 0; i < LENGTH; i++) {
            authenticateStr.append((int) (Math.random() * 10));
        }

        authInfoMapper.insertAuthNumber(memberNo, authenticateStr.toString());

        EmailVo emailVo = new EmailVo();
        emailVo.setAddress(email);
        emailVo.setSubject("Japanego Account Authenticate Mail");
        emailVo.setText("인증번호 : " + authenticateStr);
        sendEmail(emailVo);
    }

    @Override
    public boolean auth(int memberNo, String no) {
        return authInfoMapper.getMemberNoFromAuthNo(memberNo, no) > 0;
    }

    @Override
    public int auth(String randomUrl) {
        return authInfoMapper.getMemberNoFromUrl(randomUrl);
    }

    @Override
    public void checkExpired() {
        final int time = 30;
        List<AuthInfoVo> authInfoVoList = authInfoMapper.checkExpired(time);
        int sum = 0;
        for (AuthInfoVo authInfoVo : authInfoVoList) {
            sum += authInfoMapper.delete(authInfoVo);
        }
        log.info("Deleted Expired Auth_Info : " + sum);
    }

    @Override
    public void sendResetMail(int memberNo, String email) {
        String randomUrl = String.valueOf(UUID.randomUUID());
        authInfoMapper.insertAuthNumber(memberNo, randomUrl);

        EmailVo emailVo = new EmailVo();
        emailVo.setAddress(email);
        emailVo.setSubject("Japanego Init Password Link");
        emailVo.setText("<html><body>Click \n<a href='http://localhost:8282/japanego/member/reset/" + randomUrl + "'>link</a> to init password</body></html>");
        sendEmail(emailVo);
    }

    private void sendEmail(EmailVo emailVo) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            helper.setTo(emailVo.getAddress());
            helper.setSubject(emailVo.getSubject());
            helper.setText(emailVo.getText(), true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
