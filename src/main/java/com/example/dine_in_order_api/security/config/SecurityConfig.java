package com.example.dine_in_order_api.security.config;

import com.example.dine_in_order_api.config.AppEnv;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final AppEnv appEnv;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       String base_url = appEnv.getBaseUrl();
       return http.csrf(csrf -> csrf.disable())
                .securityMatchers(match -> match.requestMatchers(base_url+"/**"))
                .authorizeHttpRequests(authorize ->
                        authorize.requestMatchers(
                                base_url+"/register",
                                base_url+"/restaurants/{restaurantId}/fooditems"
                        ).permitAll().anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .build();
    }
}
