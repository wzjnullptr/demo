package com.example.test;

import com.example.mapper.UserMapper;
import com.example.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.List;

@SpringBootTest
public class MyApplicationTest {

    @Autowired
    DataSource dataSource;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        List<User> userList = userMapper.findAll();
        System.out.println(userList);
    }
}
