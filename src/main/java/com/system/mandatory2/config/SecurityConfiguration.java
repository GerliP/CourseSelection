//package com.system.mandatory2.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import javax.sql.DataSource;
//
///**
// * Created by gerli on 30/11/2017.
// */
//@EnableWebSecurity
//@Configuration
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    private final UserDetailsService userDetailsService;
//    private final DataSource dataSource;
//
//    @Autowired
//    public SecurityConfiguration(UserDetailsService userDetailsService, DataSource dataSource) {
//        this.userDetailsService = userDetailsService;
//        this.dataSource = dataSource;
//    }
//
//    @Autowired
//    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery("select email,password, active from account where email=?")
//                .authoritiesByUsernameQuery("select b.email, a.role_name from role a, account b where b.email=? and a.id=b.role_id");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/home").permitAll()
//                .antMatchers("/admin/**").access("hasRole(\"ADMIN\")")
//                .antMatchers("/teacher/**").access("hasRole(\"TEACHER\")")
//                .antMatchers("/student/**").access("hasRole(\"STUDENT\")")
//                .and().formLogin().loginPage("/login")
//                .and().logout()
//                .permitAll().and().csrf().disable();
//        http.exceptionHandling().accessDeniedPage("/403");
//
//    }
//
//    @Autowired
//    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//    }
////
////    @Bean(name = "passwordEncoder")
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//}
