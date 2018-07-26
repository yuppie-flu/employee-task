package com.takeaway.employee.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.takeaway.employee.domain.Employee;
import com.takeaway.employee.domain.Hobby;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class EmployeeDto {
    private UUID id;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Set<String> hobbies;

    public EmployeeDto(Employee employee) {
        this.id = employee.getId();
        this.email = employee.getEmail();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.birthday = employee.getBirthday();
        this.hobbies = employee.getHobbies().stream().map(Hobby::getValue).collect(Collectors.toSet());
    }
}
