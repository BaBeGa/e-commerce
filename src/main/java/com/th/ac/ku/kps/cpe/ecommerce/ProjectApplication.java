package com.th.ac.ku.kps.cpe.ecommerce;

import com.th.ac.ku.kps.cpe.ecommerce.properties.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})

public class ProjectApplication {

    public static void main(String[] args) {
        System.err.close();
        System.setErr(System.out);
        SpringApplication.run(ProjectApplication.class, args);
    }
}
