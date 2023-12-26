package org.tabbleman.oesm.controller;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tabbleman.oesm.entity.User;
import org.tabbleman.oesm.service.UserService;
import org.tabbleman.oesm.utils.dto.LoginDto;
import org.tabbleman.oesm.utils.dto.RegisterDto;

import java.util.List;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);
    // todo change to user response entity

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
    public ResponseEntity<User> login(@RequestBody LoginDto loginDto) {
        try {
            User responseUser = userService.login(loginDto);
            if(responseUser.getUserId() != null) {
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseUser);
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseUser);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new User());
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

    @PostMapping("/userInfo/upload")
    ResponseEntity<String > uploadQuestion(@RequestParam("file") MultipartFile multipartFile){
        String status = userService.uploadUserInfo(multipartFile);
        return ResponseEntity.status(HttpStatus.OK).body(status);
    }

}
