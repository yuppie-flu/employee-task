package com.takeaway.employee.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateEmployeeDto {
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
}
