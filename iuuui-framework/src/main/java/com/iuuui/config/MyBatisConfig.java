package com.iuuui.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author iuuui
 * @time 20230302 2255
 */
@Configuration
@MapperScan(basePackages = "com.iuuui.dao")
public class MyBatisConfig {
}
