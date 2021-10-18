package com.company.dao;

import com.company.model.EmployeePhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePhoneDao extends JpaRepository<EmployeePhone, Long> {
}
