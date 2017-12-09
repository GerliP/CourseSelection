//package com.system.mandatory2.domain;
//
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
///**
// * Created by gerli on 30/11/2017.
// */
//public class CustomUserDetails extends Account implements UserDetails {
//
//    public CustomUserDetails(final Account account) {
//        super(account);
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<Role> roles = new ArrayList<>();
//        roles.add(getRole());
//
//        // This is one way
////        Iterator<Role> it = roles.iterator();
////        List<SimpleGrantedAuthority> temp = new LinkedList<>();
////        while (it.hasNext()) {
////            Role r = it.next();
////            SimpleGrantedAuthority s = new SimpleGrantedAuthority(r.getRoleName());
////            temp.add(s);
////        }
//
//        // This is another way, both parts a
//        return roles
//                .stream()
//                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public String getPassword() {
//        return super.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return super.getEmail();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return super.isActive();
//    }
//}
