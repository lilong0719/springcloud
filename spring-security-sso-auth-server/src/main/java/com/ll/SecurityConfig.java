package com.ll;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.service.CustomUserService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }
	
    @Override
    protected void configure(HttpSecurity http) throws Exception { // @formatter:off
    	http.csrf().disable()
    		.requestMatchers()
        		.antMatchers("/login", "/oauth/authorize","/home")
        		.and()
        	.authorizeRequests()
            //.antMatchers("/login", "/oauth/authorize")  忽略资源
        		.antMatchers("/login","/oauth/authorize").permitAll()
        		.anyRequest().authenticated()
        		.and()
            .formLogin()
            	.loginPage("/login")
            	.usernameParameter("username").passwordParameter("password")
            	.defaultSuccessUrl("/home")
            	.permitAll()
            	.and()
            .logout()
            	.permitAll()
            	.and()
            .httpBasic();
    } // @formatter:on

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { // @formatter:off
       // auth.parentAuthenticationManager(authenticationManager)
    	/*auth.inMemoryAuthentication()
            .withUser("john")
            .password("123")
            .roles("USER");*/
    	auth.userDetailsService(customUserService());
    } // @formatter:on
    
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
