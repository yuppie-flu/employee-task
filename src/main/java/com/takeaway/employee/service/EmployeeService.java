package com.takeaway.employee.service;

import com.takeaway.employee.domain.Employee;
import com.takeaway.employee.jpa.EmployeeRepository;
import com.takeaway.employee.web.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeDto save(EmployeeDto dto) {
        try {
            Employee saved = repository.save(new Employee(dto));
            return new EmployeeDto(saved);
        } catch (Exception e) {
            throw new RuntimeException("Can not save employee", e);
        }
    }

    public Optional<EmployeeDto> read(UUID id) {
        return repository.findById(id).map(EmployeeDto::new);
    }
}
