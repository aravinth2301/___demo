package au.company.product.lib.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import au.company.product.lib.common.domain.admin.AppUser;
import au.company.product.lib.common.util.AuditorAwareImpl;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuditConfiguration {
    
        @Bean
        public AuditorAware<AppUser> auditorProvider() {
            return new AuditorAwareImpl();
        }
        
}