package com.canvas.instructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http
        .requestMatcher(new AntPathRequestMatcher("/oauth2/**"))
        .authorizeRequests(authorizeRequests ->
                authorizeRequests.antMatchers("/", "/home")
                        .permitAll()
                        .anyRequest().authenticated())
        .oauth2Login(withDefaults())
        .logout().logoutSuccessUrl("/")
        .and()
        .csrf().disable();
        
        return http.build();
	}
    @Bean
    public InMemoryClientRegistrationRepository clientRegistrationRepository() {
		  ClientRegistration clientRegistration = ClientRegistration.withRegistrationId("canvas")
                    .clientId("10000000000011")
                    .clientSecret("ETrJFvoRjPDJMyPzFcZs5kJuznE6Cxgse1E9IBsWlENBCXg3696wZIdg48xJ96xp")
                    .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                    .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                    .redirectUriTemplate("https://localhost:8080/welcome")//https://localhost:8080/login/oauth2/code/canvas
                    //.scope(SCOPES)
                    .authorizationUri("https://3.231.151.15/login/oauth2/auth")
                    .tokenUri("https://3.231.151.15/login/oauth2/token")
                    .userInfoUri("https://3.231.151.15/api/v1/users/self")
                    .userNameAttributeName("name")
                    .build();

        return new InMemoryClientRegistrationRepository(clientRegistration);
    }

}
