package com.company.service;

import com.company.model.Department;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {

    Department addDepartment(Department department, long id);

    Department editDepartment(Department department, long id);

    Department findDepartment(long id);

    void deleteDepartment(long id);

}
