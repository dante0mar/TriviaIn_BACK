package com.in.trivia.triviain.repositories;

import com.in.trivia.triviain.models.UserAnswerModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAnswerRepository extends CrudRepository<UserAnswerModel,Long>{}