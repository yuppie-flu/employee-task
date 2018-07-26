package com.takeaway.employee.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "hobbies")
@Data
@EqualsAndHashCode(of = "value")
public class Hobby {
    @Id
    @GeneratedValue
    private Long id;

    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public Hobby(String value, Employee employee) {
        this.value = value;
        this.employee = employee;
    }
}
