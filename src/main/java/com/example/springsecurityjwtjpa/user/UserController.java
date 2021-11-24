package com.example.springsecurityjwtjpa.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/getUserByName", method = RequestMethod.POST)
    public ResponseEntity<?> getUserByName(@RequestParam String userName) {
        return ResponseEntity.ok(userService.getUserByName(userName));
    }

    @RequestMapping(value = "/user/addUser", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok(userService.addUserData(loginRequestDTO));
    }
}
