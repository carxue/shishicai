package com.fzu.demo;

import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.fzu.demo.web.mapper")
public class WebtestApplicationTests {

    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void contextLoads() throws Exception {
    }

}
