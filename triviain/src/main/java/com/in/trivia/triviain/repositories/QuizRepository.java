package com.in.trivia.triviain.repositories;

import com.in.trivia.triviain.models.QuizModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends CrudRepository<QuizModel,Long>{}