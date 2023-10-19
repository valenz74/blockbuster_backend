package com.apruebaxtreme.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfigurationSource;

import com.apruebaxtreme.backend.filters.JWTLoginFilter;
import com.apruebaxtreme.backend.filters.JWTValidateFilter;

@Configuration
public class SecurityConfig {
    @Autowired
    JWTLoginFilter jwtLoginFilter;

    @Autowired
    JWTValidateFilter jwtValidateFilter;

    @Autowired
    CorsConfigurationSource corsConfigurationSource;
    
    @Bean
    public SecurityFilterChain filterSecurity(HttpSecurity http) throws Exception{

        
        http
        .cors(
                cors->cors.configurationSource(corsConfigurationSource)
        )
        .csrf(
            csrf->csrf.disable()
        )
        .authorizeHttpRequests(
            auth->{
                auth.requestMatchers(AntPathRequestMatcher.antMatcher("/inicio")).permitAll();

                auth.requestMatchers(AntPathRequestMatcher.antMatcher("/usuario")).permitAll();
                
                auth.requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll();

                auth.requestMatchers(AntPathRequestMatcher.antMatcher("/themoviedb")).hasAuthority("ADMIN");

                auth.requestMatchers(AntPathRequestMatcher.antMatcher("/peliculaalquilada")).hasAuthority("USER");
                
                auth.requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET, "/peliculacatalogo")).hasAnyAuthority("ADMIN", "USER");
                auth.requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.POST, "/peliculacatalogo")).hasAuthority("ADMIN");
                auth.requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.DELETE, "/peliculacatalogo")).hasAuthority("ADMIN");

                auth.anyRequest().authenticated();
            }
        )
        .addFilterBefore(jwtLoginFilter, UsernamePasswordAuthenticationFilter.class)
        .addFilterBefore(jwtValidateFilter, UsernamePasswordAuthenticationFilter.class)
        .sessionManagement(
            session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )
        ;

        http.headers(
            headers->headers.frameOptions(
                frameOptions->frameOptions.disable()
            )
        );

        return http.build();

    }

}
