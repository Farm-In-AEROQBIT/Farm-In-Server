package com.farminserver.api.config.security;

import com.farminserver.api.util.Jwt.JwtUtil;
import com.farminserver.api.util.Jwt.JwtRefreshFilter;
import com.farminserver.api.config.security.JwtAuthenticationFilter;
import com.farminserver.api.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    private final JwtUtil jwtUtil;
    private final AuthenticationConfiguration authenticationConfiguration;
    private final CustomUserDetailsService customUserDetailsService;

    public SecurityConfig(CustomAuthenticationEntryPoint customAuthenticationEntryPoint, JwtUtil jwtUtil, AuthenticationConfiguration authenticationConfiguration, CustomUserDetailsService customUserDetailsService) {
        this.customAuthenticationEntryPoint = customAuthenticationEntryPoint;
        this.jwtUtil = jwtUtil;
        this.authenticationConfiguration = authenticationConfiguration;
        this.customUserDetailsService = customUserDetailsService;
    }

    private static final String[] SWAGGER_WHITELIST = {
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/webjars/**",
            "/configuration/ui",
            "/configuration/security"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth
                            .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                            .requestMatchers(SWAGGER_WHITELIST).permitAll()
                            .requestMatchers("/api/user/login").permitAll()
                            .anyRequest().authenticated();
                })
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(customAuthenticationEntryPoint))
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtRefreshFilter(), UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
        return new JwtAuthenticationFilter(authenticationManagerBean(), jwtUtil);
    }

    @Bean
    public JwtRefreshFilter jwtRefreshFilter() throws Exception {
        return new JwtRefreshFilter(jwtUtil, customUserDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
