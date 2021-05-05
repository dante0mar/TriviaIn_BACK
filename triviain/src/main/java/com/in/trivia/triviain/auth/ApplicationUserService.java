package com.in.trivia.triviain.auth;

import com.in.trivia.triviain.models.UserModel;
import com.in.trivia.triviain.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService{

    @Autowired
    UserRepository userRepository;

    

    public ApplicationUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user=userRepository.findByUserName(username).orElseThrow(()-> new UsernameNotFoundException(username));
        return new ApplicationUser(user);
    }
    
}
