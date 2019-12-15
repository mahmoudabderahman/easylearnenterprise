package com.easylearn.easylearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class EasylearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasylearnApplication.class, args);
    }

    @PostConstruct
    public void init(){
        // Setting Spring Boot SetTimeZone
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

}
