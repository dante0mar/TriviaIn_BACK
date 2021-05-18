package com.in.trivia.triviain.controllers;

import java.util.Optional;

import com.in.trivia.triviain.models.QuizModel;
import com.in.trivia.triviain.services.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    
    @Autowired
    QuizService quizService;

    @GetMapping(path = "/{id}")
    public Optional<QuizModel> getQuizById(@PathVariable("id") Long id) {
        return quizService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long quizId){
        if(quizService.deleteQuiz(quizId)){
            return String.format("User %s deleted", Long.toString(quizId));
        }
        return String.format("User %s couldn't be deleted", Long.toString(quizId));
    }

    @PostMapping(path = "/save")
    public QuizModel saveQuiz(@RequestBody QuizModel newQuiz){
        return quizService.saveQuiz(newQuiz);
    }
}
