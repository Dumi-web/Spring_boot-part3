package com.dumisani.spring.part1.controller;

import com.dumisani.spring.part1.User;
import com.dumisani.spring.part1.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/user")
@RestController
public class UserController {
    private final UserServices userServices;

    @GetMapping("/")
    public String Home(){
        return "Welcome Home";
    }
    @Autowired
    public UserController(UserServices userServices){
        this.userServices = userServices;
    }
    @PostMapping()
    public void addUser(@RequestBody User user) {
        userServices.addUser(user.getId(),user.getName(),user.getSurname());
    }

    @GetMapping(path = "/{Id}")
    public String getUser(@PathVariable(value = "Id") long Id){
        return userServices.getUser(Id);
    }

    @DeleteMapping(path = "/{Id}")
    public String removeUser(@PathVariable(value = "Id") long Id){
        return userServices.removeUser(Id);
    }
}