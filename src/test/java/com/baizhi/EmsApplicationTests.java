package com.baizhi;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmsApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setUsername("kkx");
        user.setPassword("123456");
        User login = userService.login(user);
        System.out.println(login);
    }

}
