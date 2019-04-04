package com.chris.apibridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ApiBridgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiBridgeApplication.class, args);
    }

}
