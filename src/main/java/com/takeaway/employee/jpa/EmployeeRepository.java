package com.takeaway.employee.jpa;

import com.takeaway.employee.domain.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EmployeeRepository extends CrudRepository<Employee, UUID> {

}
