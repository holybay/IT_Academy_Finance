package by.it_academy.jd2.finance.user_service.controller.advice;

import by.it_academy.jd2.finance.libs.shared_lib.exception.dto.AppExceptionDtoSimple;
import by.it_academy.jd2.finance.libs.shared_lib.util.ExceptionDtoUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler
    public ResponseEntity<List<AppExceptionDtoSimple>> handle(Exception e) {
        return new ResponseEntity<>(ExceptionDtoUtil.getAppExceptionSimpleDto(e), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
