package com.in.trivia.triviain.repositories;

import com.in.trivia.triviain.models.QuestionModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<QuestionModel,Long>{}