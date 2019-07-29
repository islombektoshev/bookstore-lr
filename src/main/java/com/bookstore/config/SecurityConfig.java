package com.bookstore.config;

import com.bookstore.service.UserSecurityService;
import com.bookstore.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    public static final String PUBLIC_MATHCER[] = {
            "/css/**",
            "/js/**",
            "/img/**",
            "/fonts/**",
            "/",
            "/myaccount"
    };

    @Autowired
    private UserSecurityService userSecurityService;

    private BCryptPasswordEncoder passwordEncoder(){
        return SecurityUtility.passwordEncoder();
    }

    @Autowired
    private Environment environment;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(PUBLIC_MATHCER)
                .permitAll().anyRequest().authenticated();

        http
                .cors().disable()
                .csrf().disable()
                .formLogin().failureForwardUrl("/login?error").defaultSuccessUrl("/")
                .loginPage("/login").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/?logout").deleteCookies("remember-me").permitAll()
                .and()
                .rememberMe()
   ;
    }
}
