package au.company.product.lib.service.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class AppWebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.httpBasic().and()
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/app-login*").permitAll()
                .antMatchers("/**").authenticated()
                .and()
            .formLogin()
                .loginPage("/app-login")
                .loginProcessingUrl("/app-login")
                .defaultSuccessUrl("/vapp/dashboard")
                .failureUrl("/app-login?error=true")
                .successHandler(getAppSuccessHandler())
                .permitAll()
                .and()
            .logout()
//                .logoutUrl("/perform_logout")
                .deleteCookies("JSESSIONID")
                .permitAll();
    }

    @Override
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    protected AuthenticationManager authenticationManager() throws Exception {
    	return super.authenticationManager();
    }
    
    private AuthenticationSuccessHandler getAppSuccessHandler() {
        return new AppLoginSuccessHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}