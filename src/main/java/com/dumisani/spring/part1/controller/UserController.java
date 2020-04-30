package com.dumisani.spring.part1.controller;

import com.dumisani.spring.part1.User;
import com.dumisani.spring.part1.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/user/")
@RestController
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping("addUser/")
    public String addUser(@RequestBody User user) {
        return userServices.addUser(user.getId(),user.getName(),user.getSurname());
    }

    @GetMapping("getUser/{Id}")
    public String getUser(@PathVariable long Id){
        return userServices.getUser(Id);
    }

    @DeleteMapping("delete/{Id}")
    public String removeUser(@PathVariable long Id){
        return userServices.removeUser(Id);
    }
}