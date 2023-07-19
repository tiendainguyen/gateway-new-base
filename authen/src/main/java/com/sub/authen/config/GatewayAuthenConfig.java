package com.sub.authen.config;

import com.sub.authen.error_handle.AuthenticationErrorHandle;
import com.sub.authen.filter.TokenAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.trainingjava.core.api.exception.configuration.EnableCoreApiException;

@Configuration
@EnableWebFluxSecurity
@AllArgsConstructor
@ComponentScan(basePackages = "com.sub.authen")
//@EnableCoreApiException
public class GatewayAuthenConfig {

  private final TokenAuthenticationFilter tokenAuthenticationFilter;
  private final AuthenticationErrorHandle authenticationErrorHandle;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
    return http
        .csrf().disable()
        .authorizeExchange()
        .pathMatchers("/api/v1/auth/**").permitAll()
        .pathMatchers("/webjars/swagger-ui/**", "/v3/api-docs/**").permitAll()
        .anyExchange().authenticated()
        .and()
        .addFilterBefore(tokenAuthenticationFilter, SecurityWebFiltersOrder.AUTHENTICATION)
        .exceptionHandling()
        .authenticationEntryPoint(authenticationErrorHandle)
        .and()
        .build();
  }
  @Bean
  public WebProperties.Resources webPropertiesResources() {
    return new WebProperties.Resources();
  }
  @Bean
  public HttpStatus defaultStatus() {
    return HttpStatus.INTERNAL_SERVER_ERROR;
  }
}
