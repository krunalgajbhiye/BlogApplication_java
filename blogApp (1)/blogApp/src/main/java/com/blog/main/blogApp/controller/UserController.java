package com.blog.main.blogApp.controller;


import com.blog.main.blogApp.entity.User;
import com.blog.main.blogApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> SaveUser(@RequestBody User user){

        User saveUser = this.userService.Save(user);
        return new ResponseEntity<>(saveUser,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){

        return ResponseEntity.ok(this.userService.getUser());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@RequestBody User user,@PathVariable Long userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }
}
