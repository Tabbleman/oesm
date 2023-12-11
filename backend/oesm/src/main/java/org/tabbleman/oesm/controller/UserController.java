package org.tabbleman.oesm.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tabbleman.oesm.entity.User;
import org.tabbleman.oesm.service.UserService;
import org.tabbleman.oesm.utils.dto.LoginDto;
import org.tabbleman.oesm.utils.dto.RegisterDto;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        try {
            int state = userService.register(registerDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering user");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Long> login(@RequestBody LoginDto loginDto) {
        try {
            Long state = userService.login(loginDto);

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(state);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0L);
        }
    }
    @GetMapping("/userInfo/{userName}")
    public ResponseEntity<User> getUser(@PathVariable String userName){
        User user = userService.getUserByName(userName);
        if(user != null){
            return ResponseEntity.ok(user);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User > allUsers = userService.getAllUsers();
        if(allUsers != null){
            return ResponseEntity.ok(allUsers);
        }else {
            return null;
        }
    }
}
