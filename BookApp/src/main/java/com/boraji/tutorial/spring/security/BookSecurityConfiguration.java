package com.boraji.tutorial.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.boraji.tutorial.spring.security.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BookSecurityConfiguration extends WebSecurityConfigurerAdapter {

	// user details service
	@Autowired
	UserDetailsServiceImpl userDetailsService;
@Autowired
private JwtAuthEntryPoint unathorizedHandler;
	

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {

		return super.authenticationManagerBean();

	}

	@Bean
	private PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/api/**").permitAll().anyRequest().authenticated().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		;

	}

	// ignore url path and http method
	@Override
	public void configure(WebSecurity http) {
		http.ignoring().antMatchers(getDisabledUrlPaths());
		http.ignoring().antMatchers(HttpMethod.OPTIONS);
	}

	private String[] getDisabledUrlPaths() {
		return new String[] { "/api/login", "/api/users/signup", "/webjars/**", "/v2/api-docs/**",
				"/swagger-resources/**", "/swagger-ui.html", "/swagger/**", "/favicon.ico", "/api/swagger.json",
				"/actuator/health" };
	}

}
