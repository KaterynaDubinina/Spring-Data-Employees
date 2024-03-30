package org.example.app.repository;

import org.example.app.entity.domain.employee.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAll();
    Optional<List<Employee>> findByName(String name);
    Optional<List<Employee>> findBySurname(String surname);
}