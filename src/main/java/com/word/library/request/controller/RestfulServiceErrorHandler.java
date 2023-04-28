package com.word.library.request.controller;

import com.word.library.exception.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestfulServiceErrorHandler {

    @ExceptionHandler(value = {BookNotFoundException.class})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> handleBadRequest(BookNotFoundException bookNotFoundException) {
        switch (bookNotFoundException.getErrorMessage().getErrorCode()) {
            case DATA_NOT_FOUND_EXCEPTION, BAD_PREFIX_EXCEPTION ->
                    new ResponseEntity<>(bookNotFoundException.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(bookNotFoundException.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
