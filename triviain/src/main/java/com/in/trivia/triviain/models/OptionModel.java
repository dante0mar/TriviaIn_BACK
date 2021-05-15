package com.in.trivia.triviain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="question_option")
public class OptionModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="QUESTION_ID", nullable=false)
    private QuestionModel question;

    private String description;
    private Boolean isAnswer;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Boolean getIsAnswer() {
        return isAnswer;
    }
    public void setIsAnswer(Boolean isAnswer) {
        this.isAnswer = isAnswer;
    }
    public QuestionModel getQuestion() {
        return question;
    }
    public void setQuestion(QuestionModel question) {
        this.question = question;
    }
    
}
