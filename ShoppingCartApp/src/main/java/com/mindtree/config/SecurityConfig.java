package com.mindtree.config;

import com.mindtree.service.impl.CustomUserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Role;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Value("${custom.security.unsecured-endpoint}")
//    private List<String> unsecuredEndpoints;

//    public SecurityConfig(@Value("${custom.security.unsecured-endpoint}") List<String> unsecuredEndpoints){
//        this.unsecuredEndpoints=unsecuredEndpoints;
//        for (String endpoint:
//             unsecuredEndpoints) {
//            System.out.println(endpoint);
//        }
//    }


    @Autowired
    private CustomUserDetailsImpl customUserDetails;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetails).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/cart/**","/product/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .httpBasic(Customizer.withDefaults())
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
