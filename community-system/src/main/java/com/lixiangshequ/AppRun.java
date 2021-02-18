package com.lixiangshequ;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.lixiangshequ.repository")
public class AppRun {

    public static void main(String[] args) {
        SpringApplication.run(AppRun.class, args);
    }

}
