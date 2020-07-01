package com.projeto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.projeto.security.AuthSuccessHandler;
import com.projeto.service.UserService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userDetailsService;
	
	@Autowired
	private AuthSuccessHandler authSuccessHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET, "/").permitAll()
				.antMatchers(HttpMethod.GET, "/user/new").permitAll().antMatchers(HttpMethod.POST, "/user/save")
				.permitAll()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers( "/user/**").hasAnyRole("ADMIN", "USUARIO")
				.anyRequest().authenticated();

		http.exceptionHandling().accessDeniedPage("/unauthorized");

		http.formLogin()
			.loginPage("/login")
			.successHandler(authSuccessHandler)
			.failureUrl("/login-error")
			.permitAll();

		http.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.deleteCookies("JSESSIONID")
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutSuccessUrl("/login")
			.permitAll();
		
		http.sessionManagement()
			.invalidSessionUrl("/login")
			.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
			.maximumSessions(1)
			.sessionRegistry(new SessionRegistryImpl())
			.and()
			.sessionFixation().none();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/js/**", "/css/**");
	}
}
