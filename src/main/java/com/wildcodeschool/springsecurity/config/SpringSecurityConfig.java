package com.wildcodeschool.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/avengers/assemble").hasRole("CHAMPION");
            auth.requestMatchers("/secrets-bases").hasRole("DIRECTOR");
            auth.anyRequest().authenticated();
        }).formLogin(Customizer.withDefaults()).build();
    }

    @Bean
    public UserDetailsService users() {
        UserDetails champion = User.builder()
                .username("Steve")
                .password(passwordEncoder().encode("motdepasse"))
                .roles("CHAMPION").build();
        UserDetails director = User.builder()
                .username("Nick")
                .password(passwordEncoder().encode("flerken"))
                .roles("DIRECTOR").build();
        return new InMemoryUserDetailsManager(champion, director);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
