package com.lc;

import com.lc.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroSpringbootApplicationTests {

    @Autowired
    private UserService userService;


    @Test
    void contextLoads() {
        System.out.println(userService.selecByName("liu"));
    }

}
