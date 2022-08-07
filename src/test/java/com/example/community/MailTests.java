package com.example.community;

import com.example.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {
    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testSendMail() {
        mailClient.sendMail("836608885@qq.com", "test", "test");
    }

    @Test
    public void testHtmlMail() {
        // create a thymeleaf context
        Context context = new Context();
        // set a variable in the context
        context.setVariable("username", "ycfung");
        // render the thymeleaf template
        String content = templateEngine.process("/mail/demo", context);

        System.out.println(content);
        mailClient.sendMail("836608885@qq.com", "HTML", content);
    }
}
