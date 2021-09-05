package com.student.registration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("admin")
				.password("admin")
				.roles("ADMIN")
				.and()
				.withUser("student")
				.password("student")
				.roles("STUDENT")
				.and()
				.withUser("faculty")
				.password("faculty")
				.roles("FACULTY")
				.and()
				.withUser("principal")
				.password("principal")
				.roles("PRINCIPAL");
	}
	
	@Bean
	public PasswordEncoder getpasPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("/course/register","/course/remove/**","/course/update").hasRole("ADMIN")
		.antMatchers("/student/remove/**","/student/update").hasRole("ADMIN")
		.antMatchers("/users/remove/**","users/update").hasRole("ADMIN")
		.and().httpBasic();
	}

}
