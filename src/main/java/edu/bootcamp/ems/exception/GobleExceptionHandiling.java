package edu.bootcamp.ems.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GobleExceptionHandiling {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> hadleCustomException(CustomException exception){
        log.error(exception.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        ErrorResponse.builder()
                                .timestamp(LocalDateTime.now())
                                .Status(HttpStatus.BAD_REQUEST)
                                .Message(exception.getMessage())
                                .build()
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> hadleRuntimeException(Exception exception){
        log.error(exception.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        ErrorResponse.builder()
                                .timestamp(LocalDateTime.now())
                                .Status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .Message(exception.getMessage())
                                .build()
                );
    }
}