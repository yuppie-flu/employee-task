package com.takeaway.employee.domain;

import com.takeaway.employee.web.dto.EmployeeDto;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "employees",
        indexes =  {
                @Index(name = "unique_email", columnList = "email", unique = true)
        })
public class Employee {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false )
    private UUID id;

    private String email;
    private String firstName;
    private String lastName;
    private LocalDate birthday;

    protected Employee() {}

    public Employee(EmployeeDto employeeDto) {
        this.email = employeeDto.getEmail();
        this.firstName = employeeDto.getFirstName();
        this.lastName = employeeDto.getLastName();
        this.birthday = employeeDto.getBirthday();
    }
}
