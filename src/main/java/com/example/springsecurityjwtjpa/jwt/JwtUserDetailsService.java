package com.example.springsecurityjwtjpa.jwt;

import com.example.springsecurityjwtjpa.user.UserEntity;
import com.example.springsecurityjwtjpa.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.getUserByName(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
        }
        JwtUserDetails jwtUserDetails = new JwtUserDetails(userEntity.getUserId(), userEntity.getUserName(), userEntity.getPassword(), "admin");

        return jwtUserDetails;
    }
}
