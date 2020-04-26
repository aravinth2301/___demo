package au.company.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class VueMain {

    public static void main(String[] args) {
        SpringApplication.run(VueMain.class,args);
    }


}
