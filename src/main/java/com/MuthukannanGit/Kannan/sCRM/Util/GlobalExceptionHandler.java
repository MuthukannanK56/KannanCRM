package com.MuthukannanGit.Kannan.sCRM.Util;

import com.MuthukannanGit.Kannan.sCRM.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserService.UserAlreadyExistsException.class)
    public ResponseEntity<String> handleUserAlreadyExistsException(UserService.UserAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserService.UserNotFoundException.class)
    public ResponseEntity<String> handleUserAlreadyExistsException(UserService.UserNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserService.InvalidCredentialsException.class)
    public ResponseEntity<String> handleUserAlreadyExistsException(UserService.InvalidCredentialsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
