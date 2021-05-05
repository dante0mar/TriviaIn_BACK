package com.in.trivia.triviain.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.in.trivia.triviain.models.UserModel;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ApplicationUser implements UserDetails {

    private final List<? extends GrantedAuthority> grantedAuthorities;
    private final String password;
    private final String username;
    private final boolean isAccountNonExpired;
    private final boolean isAccountNonLocked;
    private final boolean isCredentialsNonExpired;
    private final boolean isEnabled;

    public ApplicationUser(List<? extends GrantedAuthority> grantedAuthorities, String password, String username,
    boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired,
    boolean isEnabled) {
        this.grantedAuthorities = grantedAuthorities;
        this.password = password;
        this.username = username;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
}
    public ApplicationUser(UserModel userModel){
        this.grantedAuthorities = new ArrayList();
        this.password=userModel.getPassword();
        this.username = userModel.getUserName();
        this.isAccountNonLocked = true;
        this.isAccountNonExpired=true;
        this.isCredentialsNonExpired = true;
        this.isEnabled = true;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
    
}
