package com.company.service;

import com.company.model.EmployeePhone;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeePhoneService {

    EmployeePhone addEmployeePhone(EmployeePhone employeePhone, long id);

    EmployeePhone editEmployeePhone(EmployeePhone employeePhone, long id);

    void deleteEmployeePhone(long id);

    List<EmployeePhone> findEmployeePhones(long id);

    EmployeePhone findEmployeePhone(long id);

}
