package com.easylearn.easylearn.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/home", "/", "/index.html", "/login", "/showLogin", "/login/*").permitAll()
                .antMatchers("/admin/*").hasAnyAuthority("ADMIN").anyRequest().authenticated().and().csrf().disable();
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception
    {
        return super.authenticationManagerBean();
    }
}
