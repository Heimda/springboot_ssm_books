package com.itheima;

import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.Arrays;

@SpringBootApplication
@EnableCaching//开启缓存
public class SpringbootSsmBooksApplication {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
//        SpringApplication.run(SpringbootSsmBooksApplication.class, args);
        SpringApplication.run(SpringbootSsmBooksApplication.class); 
    }

}
