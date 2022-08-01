package com.example.community;

import com.example.community.dao.AlphaDao;
import com.example.community.dao.UserMapper;
import com.example.community.entity.User;
import com.example.community.service.AlphaService;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(101);
        assert user.getUsername().equals("liubei");

        user = userMapper.selectByName("liubei");
        assert user.getEmail().equals("nowcoder101@sina.com");

        user = userMapper.selectByEmail("nowcoder101@sina.com");
        assert user.getSalt().equals("12345");

    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("ycfung");
        user.setPassword("12345678");
        user.setSalt("abc");
        user.setHeaderUrl("https://pic.cnblogs.com/avatar/922272/20220719164603.png");
        user.setCreateTime(new Date());
        user.setEmail("rcf@hotmail.co.th");

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser() {
        int rows = userMapper.updateStatus(150, 1);
        System.out.println(rows);

        rows = userMapper.updateHeader(150, "https://s2.51cto.com/oss/202107/14/fe27cd74fd4cb6462a483cb14df8e638.jpg?x-oss-process=image/ignore-error,1");
        System.out.println(rows);

        rows = userMapper.updatePassword(150, "1234567890");
        System.out.println(rows);

    }
}
