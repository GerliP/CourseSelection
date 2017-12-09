//package com.system.mandatory2.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
//
///**
// * Created by gerli on 05/12/2017.
// */
//@Configuration
//public class AuthenticationProvider {
//
//        private final Environment env;
//
//        @Autowired
//        public AuthenticationProvider(Environment env) {
//            this.env = env;
//        }
//
//        @Bean(name = "userDetailsService")
//        public UserDetailsService userDetailsService() {
//            JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
//            jdbcImpl.setDataSource(dataSource());
//            jdbcImpl.setUsersByUsernameQuery("select email,password,active from account where email=?");
//            jdbcImpl.setAuthoritiesByUsernameQuery("select b.email, a.role_name from role a, account b where b.email=? and a.id=b.role_id");
//            return jdbcImpl;
//        }
//
//        @Bean(name = "dataSource")
//        public DriverManagerDataSource dataSource() {
//            DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//            driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//            driverManagerDataSource.setUrl(env.getProperty("spring.datasource.url"));
//            driverManagerDataSource.setUsername(env.getProperty("spring.datasource.username"));
//            driverManagerDataSource.setPassword(env.getProperty("spring.datasource.password"));
//            return driverManagerDataSource;
//        }
//    }
//
