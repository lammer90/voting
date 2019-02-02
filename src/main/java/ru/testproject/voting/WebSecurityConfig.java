package ru.testproject.voting;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.testproject.voting.service.impl.auth.UserAuthService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserAuthService();
    }

    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
            /*http
                    .authorizeRequests()
                    .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                    .antMatchers("/vote/**").access("hasRole('ROLE_USER')")
                    .antMatchers("/view/**").authenticated()
                    .and()
                    .httpBasic();*/

            http
                    .httpBasic().and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                    .requestMatchers()
                    .and().authorizeRequests()
                    .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                    .antMatchers("/vote/**").access("hasRole('ROLE_USER')")
                    .antMatchers("/view/**").authenticated()
                    .and().csrf().disable();
        }
    }
}
