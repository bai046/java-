package com.jdbc.demo;

import com.jdbc.demo.entity.User;
import com.jdbc.demo.repository.UserDao;
import com.jdbc.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
class DemoApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);

    @Autowired
    DataSource dataSource;// 自动注入链接池数据源对象

    @Test
    void contextLoads() throws Exception {
        Connection connection = dataSource.getConnection();
        System.out.println("数据源："+dataSource);
        System.out.println("链接对象："+connection);
    }


    @Autowired
    private UserService userService;

    @Test
    void findUserById() {
        User user = userService.findUserById(1L);

        log.info("{}" ,user);
    }

}
