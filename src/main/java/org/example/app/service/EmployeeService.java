package org.example.app.service;

import org.example.app.entity.domain.employee.Employee;
import org.example.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public Optional<Employee> save(Employee employee) {
        return Optional.of(repository.save(employee));
    }

    public Optional<List<Employee>> getAll() {
        return Optional.of(repository.findAll());
    }

    public Employee getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Employee update(Long id, Employee employee) {
        String name = employee.getName();
        String surname = employee.getSurname();
        String position = employee.getPosition();
        String phone = employee.getPhone();
        Optional<Employee> optional = repository.findById(id);
        if (optional.isPresent()) {
            Employee employeeUpdate = optional.get();
            if (name != null)
                employeeUpdate.setName(name);
            if (surname != null)
                employeeUpdate.setSurname(surname);
            if (position != null)
                employeeUpdate.setPosition(position);
            if (phone != null)
                employeeUpdate.setPhone(phone);
            repository.save(employeeUpdate);
        }
        return repository.findById(id).orElse(null);
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else return false;
    }

    public List<Employee> getByName(String name) {
        return repository.findByName(name)
                .orElse(Collections.emptyList());
    }

    public List<Employee> getBySurname(String surname) {
        return repository.findBySurname(surname)
                .orElse(Collections.emptyList());
    }
}