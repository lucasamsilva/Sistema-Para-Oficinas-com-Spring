package com.projeto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.projeto.security.AuthSuccessHandler;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthSuccessHandler authSuccessHandler;

	@Autowired
	private PersistentTokenRepository persistentTokenRepository;

	
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
			.deleteCookies("LEMBRARID")
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
		
		http.rememberMe()
		.rememberMeCookieName("LEMBRARID")
		.rememberMeParameter("checkRememberMe")
		.tokenValiditySeconds(diasParaSegundo(12,1))
		.tokenRepository(persistentTokenRepository);
	}

	private int diasParaSegundo(int horas, int dias) {
		return (60*60*horas)*dias;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/js/**", "/css/**");
	}
	
	@Bean
	public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
		PersistentTokenBasedRememberMeServices persistentTokenBasedService = new PersistentTokenBasedRememberMeServices("LEMBRARID", userDetailsService, persistentTokenRepository);
		persistentTokenBasedService.setAlwaysRemember(true);
		return persistentTokenBasedService;
		
	}
}
