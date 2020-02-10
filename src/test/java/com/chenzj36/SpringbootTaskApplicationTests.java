package com.chenzj36;

import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Properties;

@SpringBootTest
class SpringbootTaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("chenzj36@live.cn");
        message.setFrom("chenzj36@126.com");
//        message.setBcc("chenzj36@126.com"); // 给自己抄送一份，解决554
        message.setSubject("所有苦涩皆是幸福的铺垫");
        message.setText("只愿世间风景千般万般熙攘过后，字里行间，人我两忘，相对无言");
        mailSender.send(message);
    }

    @Test
    void contextLoads2() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);

        messageHelper.setTo("chenzj36@live.cn");
        messageHelper.setFrom("chenzj36@126.com");
        messageHelper.setSubject("from springboot");
        messageHelper.setText("<p style='color:red'>一座城市令你念念不忘，大多是因为，那里有你深爱的人和一去不复返的青春~</p>",true);
        messageHelper.addAttachment("1.jpg",new File("E:\\screen\\2020-02-10_10-19-06.jpg"));
        messageHelper.addAttachment("2.jpg",new File("E:\\screen\\2020-02-08_13-27-45.jpg"));

        mailSender.send(mimeMessage);
    }


}
