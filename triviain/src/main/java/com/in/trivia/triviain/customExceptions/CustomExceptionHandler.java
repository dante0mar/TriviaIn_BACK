package com.in.trivia.triviain.customExceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
 
@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler 
{
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex, 
      HttpHeaders headers, 
      HttpStatus status, 
      WebRequest request){
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        
        final List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        final List<CustomFieldError> customFieldErrors = new ArrayList<>();

        for (FieldError fieldError : fieldErrors) {

            final String field = fieldError.getField();

            final String message = fieldError.getDefaultMessage();

            final CustomFieldError customFieldError = new CustomFieldError(field,message);

            customFieldErrors.add(customFieldError);

        }

        return new ResponseEntity(customFieldErrors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}