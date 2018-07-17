package com.takeaway.employee.service;

import com.takeaway.employee.domain.Employee;
import com.takeaway.employee.jpa.EmployeeRepository;
import com.takeaway.employee.web.dto.EmployeeDto;
import com.takeaway.employee.web.dto.UpdateEmployeeDto;
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
            // TODO: proper error handling
            throw new RuntimeException("Can not save employee", e);
        }
    }

    public Optional<EmployeeDto> read(UUID id) {
        return repository.findById(id).map(EmployeeDto::new);
    }

    public Optional<EmployeeDto> update(UUID id, UpdateEmployeeDto updateDto) {
        try {
            Optional<Employee> foundEmployee = repository.findById(id).map(e -> update(e, updateDto));
            foundEmployee.ifPresent(repository::save);
            return foundEmployee.map(EmployeeDto::new);
        } catch (Exception e) {
            // TODO: proper error handling
            throw new RuntimeException("Can not save employee", e);
        }
    }

    private Employee update(Employee employee, UpdateEmployeeDto updateDto) {
        Optional.ofNullable(updateDto.getEmail()).ifPresent(employee::setEmail);
        Optional.ofNullable(updateDto.getFirstName()).ifPresent(employee::setFirstName);
        Optional.ofNullable(updateDto.getLastName()).ifPresent(employee::setLastName);
        Optional.ofNullable(updateDto.getBirthday()).ifPresent(employee::setBirthday);
        return employee;
    }
}
