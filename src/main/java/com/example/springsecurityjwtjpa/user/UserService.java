package com.example.springsecurityjwtjpa.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity addUserData(LoginRequestDTO loginRequestDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(loginRequestDTO.getUserName());
        userEntity.setPassword(new BCryptPasswordEncoder().encode(loginRequestDTO.getPassword()));
        return userRepository.save(userEntity);
    }

    public UserEntity getUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
