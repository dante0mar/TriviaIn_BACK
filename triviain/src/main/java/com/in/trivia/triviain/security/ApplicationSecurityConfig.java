package com.in.trivia.triviain.security;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletResponse;

import com.in.trivia.triviain.auth.ApplicationUserService;
import com.in.trivia.triviain.auth.JwtTokenFilter;
import com.in.trivia.triviain.auth.JwtTokenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;
    private final JwtTokenFilter jwtTokenFilter;


    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder,ApplicationUserService applicationUserService,JwtTokenFilter jwtTokenFilter){
        this.passwordEncoder= passwordEncoder;
        this.applicationUserService = applicationUserService;
        this.jwtTokenFilter=jwtTokenFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    http
        // Enable CORS and disable CSRF
        .cors().and().csrf().disable()

        // Set session management to stateless
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()

        // Set unauthorized requests exception handler
        .exceptionHandling()
        .authenticationEntryPoint(
            (request, response, ex) -> {
                response.sendError(
                    HttpServletResponse.SC_UNAUTHORIZED,
                    ex.getMessage()
                );
            }
        )
        .and()

        .authorizeRequests()
        .antMatchers("/index.html", "/", "/home", "/login", "/user/signup", "/api/public/login").permitAll()
        .anyRequest().authenticated();

        // Add JWT token filter
        http.addFilterBefore(
            jwtTokenFilter,
            UsernamePasswordAuthenticationFilter.class
        );
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);
        return provider;
    }

    // Used by spring security if CORS is enabled.
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source =
            new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.addExposedHeader("Authorization");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Override @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
}
