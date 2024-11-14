package by.it_academy.jd2.finance.user_service.controller.advice;

import by.it_academy.jd2.finance.libs.shared_lib.exception.ValidationException;
import by.it_academy.jd2.finance.libs.shared_lib.exception.dto.AppExceptionDtoSimple;
import by.it_academy.jd2.finance.libs.shared_lib.exception.dto.AppExceptionDtoStructured;
import by.it_academy.jd2.finance.libs.shared_lib.exception.dto.StructuredExceptionDto;
import by.it_academy.jd2.finance.libs.shared_lib.util.ExceptionDtoUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler
    public ResponseEntity<List<AppExceptionDtoSimple>> handle(Exception e) {
        return new ResponseEntity<>(ExceptionDtoUtil.getAppExceptionSimpleDto(e), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<List<AppExceptionDtoSimple>> handle(MethodArgumentTypeMismatchException e) {
        return new ResponseEntity<>(ExceptionDtoUtil.getAppExceptionSimpleDto(e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<List<AppExceptionDtoSimple>> handle(NoResourceFoundException e) {
        return new ResponseEntity<>(ExceptionDtoUtil.getAppExceptionSimpleDto(e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<AppExceptionDtoStructured> handle(ValidationException e) {
        AppExceptionDtoStructured out = new AppExceptionDtoStructured(
                ExceptionDtoUtil.convertToStructuredExceptionDtoList(e.getErrors()));
        return new ResponseEntity<>(out, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<AppExceptionDtoStructured> handle(HandlerMethodValidationException e) {
        List<StructuredExceptionDto> errorList = e.getAllValidationResults().stream()
                                                  .map(er -> new StructuredExceptionDto(
                                                          er.getMethodParameter().getParameterName(),
                                                          er.getResolvableErrors().get(0).getDefaultMessage()))
                                                  .toList();
        AppExceptionDtoStructured out = new AppExceptionDtoStructured(errorList);
        return new ResponseEntity<>(out, HttpStatus.BAD_REQUEST);
    }
}
