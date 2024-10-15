package com.arnab.spring13_jwt.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	//    creating dynamic UserDetailsService
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtFilter jwtFilter;

	@Bean
	public AuthenticationProvider authenticationProvider(){
//        as we connected with Database so create DaoAuthenticationProvider
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);

//        as we don't need any encoder
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

		provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
		return provider;

	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        With Lambda (that we will generally use)

//        CSRF Disable
		http.csrf(CsrfConfigurer::disable);
//        authenticate all requests
		http.authorizeHttpRequests(request-> request
				.requestMatchers("/register","/login")
				.permitAll()
				.anyRequest().authenticated());

//        crate basic form
//        http.formLogin(Customizer.withDefaults());
		http.httpBasic(Customizer.withDefaults());

//        create Http stateless
		http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

//		creating JWT Filter before UsernamePasswordAuthenticationFilter
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

}
