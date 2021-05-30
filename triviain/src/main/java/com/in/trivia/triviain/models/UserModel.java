package com.in.trivia.triviain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.in.trivia.triviain.validators.ValidPassword;

@Entity
@Table(name="user")
public class UserModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;
    
    @NotBlank(message = "Please, add a valid userName, it cannot be blank")
    private String userName;

    @ValidPassword(message = "Invalid password, it should have at least 8 characters, 1 Upper case, 1 Lower case and one digit, also, not whitespaces")
    private String password;

    private Boolean active;
    private String roles;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Please, add a valid userName, it cannot be blank")
    private String email;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public String getRoles() {
        return roles;
    }
    public void setRoles(String roles) {
        this.roles = roles;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
