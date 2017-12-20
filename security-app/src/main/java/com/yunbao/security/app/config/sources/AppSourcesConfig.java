package com.yunbao.security.app.config.sources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableResourceServer
public class AppSourcesConfig  extends ResourceServerConfigurerAdapter{

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;


  /*  @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;*/


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/user/requierd")
                .loginProcessingUrl("/user/login")
                .successHandler(authenticationSuccessHandler)
                .and()
                .csrf().disable()
                .authorizeRequests().antMatchers("/user/requierd","/user/login").permitAll()
                .anyRequest().authenticated();


    }

}
