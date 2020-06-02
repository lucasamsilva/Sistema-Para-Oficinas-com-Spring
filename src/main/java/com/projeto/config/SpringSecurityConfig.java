package com.projeto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.projeto.service.UserService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET,"/").permitAll().antMatchers(HttpMethod.GET,"/user/new").permitAll()
		.antMatchers(HttpMethod.POST,"/user/save").permitAll()
		.antMatchers(HttpMethod.GET,"/admin/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET,"/user/**").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().exceptionHandling().accessDeniedPage("/unauthorized")
		.and().formLogin()
		.loginPage("/login").defaultSuccessUrl("/home").failureUrl("/login-error")
		.permitAll()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	public void configure (WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/js/**", "/css/**");
	}
}
