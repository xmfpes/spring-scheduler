package com.kyunam.springscheduler.security;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


import groovy.util.logging.Log;

@Log
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	DataSource dataSource;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/css/**", "/js/**", "/images/**", "/resources/**", "/webjars/**", "/foundry/**").permitAll();
		
        http
            .authorizeRequests()
                .antMatchers("/", "/users/registerForm", "/users/**", "/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
            		.defaultSuccessUrl("/users")
            		.failureUrl("/users/registerForm")
                .loginPage("/users/loginForm")
                .permitAll()
                .and()
            .logout()
            .permitAll();
    }
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("SELECT uid username, upw password, true enable FROM member where uid = ?")
		.rolePrefix("ROLE_")
		.authoritiesByUsernameQuery("select member uno, role_name role from member_role where member = ?");
	
    }
}