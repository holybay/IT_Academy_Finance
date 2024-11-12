package by.it_academy.jd2.finance.user_service.controller.advice;


import by.it_academy.jd2.finance.libs.shared_lib.exception.ApplicationStructuredException;
import by.it_academy.jd2.finance.libs.shared_lib.exception.dto.AppExceptionDtoSimple;
import by.it_academy.jd2.finance.libs.shared_lib.exception.dto.AppExceptionDtoStructured;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler
    public ResponseEntity<AppExceptionDtoStructured> handle(ApplicationStructuredException e) {
        AppExceptionDtoStructured error = new AppExceptionDtoStructured();
        error.getErrors().add(e);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<List<AppExceptionDtoSimple>> handle(Exception e) {
        List<AppExceptionDtoSimple> errors = new ArrayList<>();
        errors.add(new AppExceptionDtoSimple(e.getMessage()));
        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
