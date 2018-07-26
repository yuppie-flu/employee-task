package com.takeaway.employee.web;

import com.takeaway.employee.web.dto.ErrorDto;
import com.takeaway.employee.web.ex.EmployeeNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class EmployeeServiceControllerAdvice {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    public ErrorDto dataConflictException(DataIntegrityViolationException e) {
        String message = e.getMostSpecificCause().getMessage();
        log.error("Data conflict", e.getMostSpecificCause());
        if (message.contains("UNIQUE_EMAIL_INDEX")) {
            return new ErrorDto("Employee with the same e-mail already exists");
        }
        return new ErrorDto("There is a conflict with some existing employee");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseBody
    public ErrorDto dataConflictException(EmployeeNotFoundException e) {
        return new ErrorDto("Employee with the given id was not found");
    }
}
