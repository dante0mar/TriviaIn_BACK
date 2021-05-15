package com.in.trivia.triviain.repositories;

import java.util.Optional;

import com.in.trivia.triviain.models.UserModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel,Long>{
    Optional<UserModel> findByUserName(String userName);
}
