package com.in.trivia.triviain.controllers;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import com.in.trivia.triviain.models.UserModel;
import com.in.trivia.triviain.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService userService;


    @GetMapping()
    public ArrayList<UserModel> getUsers(){
        return userService.getUsers();
    }

    @PostMapping(path = "/signup")
    public UserModel saveUser(@RequestBody @Valid UserModel newUser){
        return userService.saveUser(newUser);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long userId){
        if(this.userService.deleteUser(userId)){
            return String.format("User %s deleted", Long.toString(userId));
        }
        return String.format("User %s couldn't be deleted", Long.toString(userId));
    }
    
}
