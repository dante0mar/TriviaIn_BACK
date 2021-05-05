package com.in.trivia.triviain.services;

import java.util.ArrayList;
import java.util.Optional;

import com.in.trivia.triviain.models.UserModel;
import com.in.trivia.triviain.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel newUser){
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }

    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }

    public boolean deleteUser(Long userId){
        try{
            userRepository.deleteById(userId);
            return true;
        }catch(IllegalArgumentException illegalArgException){
            return false;
        }
    }

}
