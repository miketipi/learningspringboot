package org.example.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
//no need to hard code in memory user
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails john = User.builder().username("john").password("{noop}test123").
//                roles("EMPLOYEE").build();
//        UserDetails susan = User.builder().username("susan").password("{noop}test123").
//                roles("EMPLOYEE", "MANAGER").build();
//        UserDetails mary = User.builder().username("mary").password("{noop}test123").
//                roles("EMPLOYEE", "MANAGER", "ADMIN").build();
//        return new InMemoryUserDetailsManager(john, susan, mary);
//    }


    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        //Jbdc user details manager to implement bean datasource
        //Spring security expects 2 default table for authen and author (users and authorities)
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees").hasRole("ADMIN"));
        http.httpBasic(Customizer.withDefaults());
        //might not use csrf
        http.csrf(c -> c.disable());
        return http.build();
    }
}
