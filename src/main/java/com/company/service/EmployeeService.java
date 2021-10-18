package com.company.service;

import com.company.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    Employee addEmployee(Employee employee, long id);

    Employee editEmployee(Employee employee, long id);

    Employee findEmployee(long id);

    void deleteEmployee(long id);

    List<Employee> findEmployees();

}
