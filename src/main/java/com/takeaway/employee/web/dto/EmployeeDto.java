package com.takeaway.employee.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.takeaway.employee.domain.Employee;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeDto {
    private UUID id;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate birthday;

    protected EmployeeDto() {}

    public EmployeeDto(Employee employee) {
        this.id = employee.getId();
        this.email = employee.getEmail();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.birthday = employee.getBirthday();
    }
}
