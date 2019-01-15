package com.acn.masg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.acn.masg.filter.JwtAuthenticationFilter;
import com.acn.masg.filter.JwtLoginFilter;

@Configuration
@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.passwordEncoder( new PasswordEncoder() {

			@Override
			public String encode(CharSequence rawPassword) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return rawPassword.toString().equals(encodedPassword);
			}
			
		}
		)
		.withUser("Frank Pengqiang Li").password("abcd1234").authorities("USER")
		.and()
		.withUser("Kerry").password("abcd1234").authorities("MASG");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors()	
		.and()
			.csrf()
			.disable()
			.authorizeRequests()
//			.anyRequest().authenticated()
			.anyRequest().permitAll()
        .and()
	        .addFilter(new JwtLoginFilter(authenticationManager()))
	        .addFilter(new JwtAuthenticationFilter(authenticationManager()));
	}

}