package com.in.trivia.triviain.services;

import java.util.List;

import com.in.trivia.triviain.models.OptionModel;
import com.in.trivia.triviain.models.QuestionModel;
import com.in.trivia.triviain.models.QuizModel;
import com.in.trivia.triviain.repositories.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    OptionService optionService;


    public QuestionModel saveQuestion(QuestionModel newQuestion){
        return questionRepository.save(newQuestion);
    }

    public void saveQuestions(List<QuestionModel> questions,QuizModel savedQuizModel){
        questions.forEach(question->{
            question.setQuiz(savedQuizModel);
            List<OptionModel> options = question.getOptions();
            question.setOptions(List.of());
            questionRepository.save(question);
            options.forEach(option->option.setQuestion(question));
            optionService.saveOptions(options);
        });
    }
}
