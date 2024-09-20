package com.arnab.spring12_springsecurity.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        without Lambda

//        CSRF Disable
//        create the object and pass it
//        Customizer<CsrfConfigurer<HttpSecurity>> csrf=new Customizer<CsrfConfigurer<HttpSecurity>>() {
//            @Override
//            public void customize(CsrfConfigurer<HttpSecurity> httpSecurityCsrfConfigurer) {
//                httpSecurityCsrfConfigurer.disable();
//            }
//        };
//        http.csrf(csrf);

//        authenticate all requests
//        Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> custHttp=new Customizer<AuthorizeHttpRequestsConfigurer<org.springframework.security.config.annotation.web.builders.HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
//            @Override
//            public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authorizationManagerRequestMatcherRegistry) {
//                authorizationManagerRequestMatcherRegistry.anyRequest().authenticated();
//            }
//        };
//        http.authorizeHttpRequests(custHttp);

//        With Lambda (that we will generally use)

//        CSRF Disable
        http.csrf(customizer->customizer.disable());
//        authenticate all requests
        http.authorizeHttpRequests(request-> request.anyRequest().authenticated());

//        crate basic form
//        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());

//        create Http stateless
        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

//  creating own UserDetailService
    @Bean
    public UserDetailsService userDetailsService(){
//        creating users
        UserDetails user=User.withDefaultPasswordEncoder()
                            .username("Ayan")
                            .password("1234")
                            .roles("USER")
                            .build();

        UserDetails admin=User.withDefaultPasswordEncoder()
                            .username("admin")
                            .password("789")
                            .roles("ADMIN")
                            .build();
        return new InMemoryUserDetailsManager(user,admin);
    }
}
