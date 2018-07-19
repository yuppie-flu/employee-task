package com.takeaway.employee.domain;

import com.takeaway.employee.web.dto.EmployeeDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "employees",
        indexes =  {
                @Index(name = "unique_email", columnList = "email", unique = true)
        })
public class Employee {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;

    private String email;
    private String firstName;
    private String lastName;
    private LocalDate birthday;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
    private Set<Hobby> hobbies = new HashSet<>();

    public Employee(EmployeeDto employeeDto) {
        this.email = employeeDto.getEmail();
        this.firstName = employeeDto.getFirstName();
        this.lastName = employeeDto.getLastName();
        this.birthday = employeeDto.getBirthday();
        this.hobbies = employeeDto.getHobbies()
                                  .stream()
                                  .map(h -> new Hobby(h, this))
                                  .collect(Collectors.toSet());
    }
}
