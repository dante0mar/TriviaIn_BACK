package com.in.trivia.triviain.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.in.trivia.triviain.models.QuestionModel;
import com.in.trivia.triviain.models.QuizModel;
import com.in.trivia.triviain.repositories.QuizRepository;
import com.in.trivia.triviain.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
    
    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionService questionService;

    @Autowired
    UserRepository userRepository;


    public Optional<QuizModel> getById(Long id){
        return quizRepository.findById(id);
    }

    public QuizModel saveQuiz(QuizModel newQuiz){
        List<QuestionModel> toSaveList= newQuiz.getQuestions();
        newQuiz.setQuestions(List.of());
        QuizModel savedModel = quizRepository.save(addUserExtraDataToStore(newQuiz));
        toSaveList.forEach(question->question.setQuiz(savedModel));
        questionService.saveQuestions(toSaveList);
        return savedModel;
    }

    public boolean deleteQuiz(Long quizId){
        try{
            quizRepository.deleteById(quizId);
            return true;
        }catch(IllegalArgumentException illegalArgException){
            return false;
        }
    }

    private QuizModel addUserExtraDataToStore(QuizModel newQuiz){
        newQuiz.setCreationDate(new Date(new java.util.Date().getTime()));
        UserDetails principal = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        newQuiz.setUser(userRepository.findByUserName(principal.getUsername()).get());
        return newQuiz;
    }

}
