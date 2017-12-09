//package com.system.mandatory2.service;
//
//import com.system.mandatory2.domain.Account;
//import com.system.mandatory2.domain.CustomUserDetails;
//import com.system.mandatory2.repositories.AccountRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
///**
// * Created by gerli on 30/11/2017.
// */
//@Service
//public class CustomUserDetailsService implements UserDetailsService{
//
//    @Autowired
//    private AccountRepo accountRepo;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Account> accountOptional = accountRepo.findByEmail(username);
//
////        accountOptional.ifPresent(account ->{
////                new CustomUserDetails(account);
////    });
//    accountOptional.orElseThrow(() -> new UsernameNotFoundException("Username Not Found"));
//        return accountOptional.map(CustomUserDetails::new).get();
//    }
//}
