package com.example.user.controller;

import com.example.user.entity.UserInfo;
import com.example.user.service.UserService;
import com.example.user.valueobject.UserDepartmentWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public UserInfo saveUser(@RequestBody UserInfo userInfo){
        log.info("Inside saveUser of UserController ");
        return userService.saveUser(userInfo);
    }

    @GetMapping("/{userId}")
    public UserDepartmentWrapper getUserWithDepartment(@PathVariable("userId") Long userId){
        log.info("inside getUserWithDepartment of userController");
        return userService.findUserWithDepartment(userId);
    }

}
