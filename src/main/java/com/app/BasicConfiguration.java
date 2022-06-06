package com.app;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication()
				.withUser("user").password(encoder.encode("user")).roles("USER")
				.and().withUser("admin").password(encoder.encode("admin")).roles("USER", "ADMIN")
				.and().withUser("super").password(encoder.encode("super")).roles("USER", "ADMIN", "SUPER");
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();

		http.exceptionHandling().authenticationEntryPoint(

				(request, response, ex) -> {
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
				}

		).and();

		http.authorizeRequests().antMatchers("/actuator/**").hasAnyRole("SUPER")
				.antMatchers("/product/create", "/product/delete/**").hasAnyRole("ADMIN")
				.antMatchers("/product/update", "/product/products", "/product/searchByName/**,/product/searchBy/**").hasAnyRole("USER")
				.antMatchers("/authenticate").permitAll()
				.anyRequest().authenticated().and().httpBasic();

	}
}
