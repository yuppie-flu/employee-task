package com.takeaway.employee.service;

import com.takeaway.employee.domain.Employee;
import com.takeaway.employee.jpa.EmployeeRepository;
import com.takeaway.employee.web.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeDto save(EmployeeDto dto) {
        try {
            Employee saved = employeeRepository.save(new Employee(dto));
            return new EmployeeDto(saved);
        } catch (Exception e) {
            throw new RuntimeException("Can not save employee", e);
        }
    }
}
