package com.udacity.jdnd.webapp1.chat.config;

import com.udacity.jdnd.webapp1.chat.service.AuthenticationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final AuthenticationService authenticationService;

    public SecurityConfig(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests
                .requestMatchers("/signup", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated()
        ).formLogin(form -> form
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/chat", true)
        );

        http.authenticationProvider(authenticationService);

        return http.build();
    }

}
