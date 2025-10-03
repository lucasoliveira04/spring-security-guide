package com.springsecurityguia.springsecurityguia.config;

import com.springsecurityguia.springsecurityguia.service.JwtAuthentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtAuthentication jwtAuthentication) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/api/user/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")

                        .requestMatchers("/api/auth/**").permitAll()

                        .anyRequest().authenticated()
                )
                .headers(headers -> headers.frameOptions(frame -> frame.disable()))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthentication, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
