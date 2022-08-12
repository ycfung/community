package com.example.community;

import com.example.community.service.AlphaService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class TransactionTests {

    @Autowired
    private AlphaService alphaService;

    @Test
    public void testSave1() {
        assertThrows(NumberFormatException.class,()->{
            Object obj = alphaService.save1();
            System.out.println(obj);
        });

    }

    @Test
    public void testSave2() {
        assertThrows(NumberFormatException.class,()->{
            Object obj = alphaService.save2();
            System.out.println(obj);
        });
    }

}
