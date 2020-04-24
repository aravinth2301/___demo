package au.company.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@SpringBootApplication

public class VueMain {

    public static void main(String[] args) {
        SpringApplication.run(VueMain.class,args);
    }


}
