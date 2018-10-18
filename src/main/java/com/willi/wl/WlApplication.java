package com.willi.wl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.willi.wl.mapper")
@EnableSwagger2
public class WlApplication {

    public static void main(String[] args) {
        SpringApplication.run(WlApplication.class, args);
    }
}
