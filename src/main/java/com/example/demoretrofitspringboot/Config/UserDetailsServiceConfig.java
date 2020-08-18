package com.example.demoretrofitspringboot.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demoretrofitspringboot.user.UserRepository;

@Configuration
public class UserDetailsServiceConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserRepository();
	}
}
