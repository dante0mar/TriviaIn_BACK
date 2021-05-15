package com.in.trivia.triviain.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.in.trivia.triviain.enums.QuestionKind;

@Entity
@Table(name="question")
public class QuestionModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;

    private String title;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="question")
    private List<OptionModel> options;

    @ManyToOne
    @JoinColumn(name="QUIZ_ID", nullable=false)
    private QuizModel quiz;

    @Enumerated(EnumType.ORDINAL)
    private QuestionKind questionKind;

    private String optionalLink;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<OptionModel> getOptions() {
        return options;
    }

    public void setOptions(List<OptionModel> options) {
        this.options = options;
    }

    public QuestionKind getQuestionKind() {
        return questionKind;
    }

    public void setQuestionKind(QuestionKind questionKind) {
        this.questionKind = questionKind;
    }

    public String getOptionalLink() {
        return optionalLink;
    }

    public void setOptionalLink(String optionalLink) {
        this.optionalLink = optionalLink;
    }


    public QuizModel getQuiz() {
        return quiz;
    }

    public void setQuiz(QuizModel quiz) {
        this.quiz = quiz;
    }
    
}
