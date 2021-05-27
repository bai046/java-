package com.yy.FB;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yy.FB.mapper")
public class FBApplication {
    public static void main(String[] args) {
        SpringApplication.run(FBApplication.class,args);
    }
}
