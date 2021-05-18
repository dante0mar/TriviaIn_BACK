package com.in.trivia.triviain.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.in.trivia.triviain.models.OptionModel;
import com.in.trivia.triviain.repositories.OptionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionService {
    
    @Autowired
    OptionRepository optionRepository;

    
    public void saveOptions(List<OptionModel> newOption){
        optionRepository.saveAll(newOption);
    }

    
}
