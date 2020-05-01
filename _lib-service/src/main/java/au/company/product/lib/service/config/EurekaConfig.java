package au.company.product.lib.service.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile(value = {"docker","default"})
@Configuration
@EnableDiscoveryClient
public class EurekaConfig {

}
