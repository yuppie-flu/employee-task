package com.takeaway.employee.web.ex;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "employee with the given id was not found")
public class EmployeeNotFoundException extends RuntimeException {}
