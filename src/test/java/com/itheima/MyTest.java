package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @aythor YOLO
 * @create 2022--06--14 9:22
 */

@SpringBootTest()
public class MyTest {
    @Test
    void test1(){
        String format = String.format("%04d", 1);
        System.out.println(format);

        String format1 = String.format("%.5s", "0.02172");
        System.out.println(format1);

        String format2 = String.format("%.2f", 0.21772);
        System.out.println(Double.parseDouble(format2));
    }
}
