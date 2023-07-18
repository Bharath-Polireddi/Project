package com.finance.PsnlExp.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity
public class InMemory {

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
		UserDetails user1 = User.withUsername("Michael").password(passwordEncoder.encode("michael@123")).build();

		UserDetails user2 = User.withUsername("Jesse").password(passwordEncoder.encode("jesse@123")).build();

		UserDetails user3 = User.withUsername("Mahone").password(passwordEncoder.encode("mahone@123")).build();

		UserDetails user4 = User.withUsername("Sara").password(passwordEncoder.encode("sara@123")).build();

		UserDetails user5 = User.withUsername("Walter").password(passwordEncoder.encode("walter@123")).build();

		return new InMemoryUserDetailsManager(user1, user2, user3, user4, user5);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return encoder;
	}
}
