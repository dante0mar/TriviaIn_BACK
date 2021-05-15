package com.in.trivia.triviain.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_answer")
public class UserAnswer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;
    
    @ManyToOne
    private OptionModel selectedOption;
    
    @ManyToOne
    private UserModel selectingUser;
    
    private Date selectionTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OptionModel getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(OptionModel selectedOption) {
        this.selectedOption = selectedOption;
    }

    public UserModel getSelectingUser() {
        return selectingUser;
    }

    public void setSelectingUser(UserModel selectingUser) {
        this.selectingUser = selectingUser;
    }

    public Date getSelectionTime() {
        return selectionTime;
    }

    public void setSelectionTime(Date selectionTime) {
        this.selectionTime = selectionTime;
    }

    
}
