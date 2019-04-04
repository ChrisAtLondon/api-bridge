package com.chris.apibridge.config;

import com.chris.apibridge.security.BridgeAuthenticationProvider;
import com.chris.apibridge.security.BridgeAuthenticationProcessingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  private BridgeAuthenticationProvider authenticationProvider;

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Bean
  BridgeAuthenticationProcessingFilter bridgeAuthenticationProcessingFilter() throws Exception{
    BridgeAuthenticationProcessingFilter bridgeAuthenticationProcessingFilter = new BridgeAuthenticationProcessingFilter();
    bridgeAuthenticationProcessingFilter.setAuthenticationManager(authenticationManagerBean());
    return bridgeAuthenticationProcessingFilter;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
            .authorizeRequests()
//            .antMatchers("/swagger-ui.html")
            .antMatchers("/**")
            .permitAll();
//            .and()
//            .addFilterBefore(bridgeAuthenticationProcessingFilter(), BasicAuthenticationFilter.class);
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authenticationProvider);
  }
}
