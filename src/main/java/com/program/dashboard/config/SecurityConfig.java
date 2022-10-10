package com.program.dashboard.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SecurityConfig {


    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){

        UserDetails user1 = User.builder()
                .username("tzuyu")
                .password("{noop}123")
                .roles("ADMIN")
                .build();

        UserDetails user2 = User.builder()
                .username("sana")
                .password("{noop}123")
                .roles("ADMIN")
                .build();

        UserDetails user3 = User.builder()
                .username("Park Jihyo")
                .password("{noop}123")
                .roles("LEADER")
                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.authorizeRequests(
                configurer -> {
                    configurer
                            .antMatchers("/").permitAll()
                            .antMatchers("/dashboard/**").hasRole("ADMIN")
                            .antMatchers(
                            "/js/**",
                                        "/css/**",
                                        "/img/**",
                                        "/scss/**",
                                        "/vendor/**",
                                        "/webjars/**").permitAll();
                }
        )
                .formLogin(configurer -> {
                    configurer
                            .loginPage("/login")
                            .loginProcessingUrl("/authenticateTheUser")
                            .permitAll();
                })
                .logout(configurer -> configurer.logoutSuccessUrl("/").permitAll())
                .exceptionHandling(configurer -> {
                    configurer
                            .accessDeniedPage("/access-denied");
                })
                .build();

    }

}
