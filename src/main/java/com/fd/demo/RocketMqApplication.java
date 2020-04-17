package com.fd.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author ：zxq
 * @date ：Created in 2020/4/16 14:56
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RocketMqApplication {
    public static void main(String[] args) {
        SpringApplication.run(RocketMqApplication.class, args);
    }
}
