package com.in.trivia.triviain.repositories;

import com.in.trivia.triviain.models.OptionModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends CrudRepository<OptionModel,Long>{}