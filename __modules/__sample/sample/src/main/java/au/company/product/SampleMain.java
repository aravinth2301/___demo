package au.company.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleMain {

    public static void main(String[] args) {
        // System.setProperty("spring.config.name", "sample,application");
        SpringApplication.run(SampleMain.class, args);
    }
}
