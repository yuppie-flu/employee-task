package com.takeaway.employee.web;

import com.takeaway.employee.service.EmployeeService;
import com.takeaway.employee.web.dto.EmployeeDto;
import com.takeaway.employee.web.ex.EmployeeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public EmployeeDto create(@RequestBody EmployeeDto employeeDto) {
        return service.save(employeeDto);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public EmployeeDto read(@PathVariable UUID id) {
        return service.read(id).orElseThrow(EmployeeNotFoundException::new);
    }
}
