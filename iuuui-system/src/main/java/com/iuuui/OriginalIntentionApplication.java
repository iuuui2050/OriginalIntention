package com.iuuui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author iuuui
 * @time 20230227 2211
 */
@SpringBootApplication
@Controller
@MapperScan(basePackages = "com.iuuui.dao")
public class OriginalIntentionApplication {

    public static void main(String[] args) {
        SpringApplication.run(OriginalIntentionApplication.class, args);
    }

    @GetMapping(value = "/hello")
    @ResponseBody
    public String hello() {
        return "Hello, world!";
    }

}
