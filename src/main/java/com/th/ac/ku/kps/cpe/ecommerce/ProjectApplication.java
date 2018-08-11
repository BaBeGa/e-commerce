package com.th.ac.ku.kps.cpe.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication {

    public static void main(String[] args) {
        System.err.close();
        System.setErr(System.out);
        SpringApplication.run(ProjectApplication.class, args);
    }
}
