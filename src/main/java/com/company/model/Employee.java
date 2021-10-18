package com.company.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String address;

    private double salary;

    private String hiringDate;

    private String birthDate;

    @ManyToOne
    @JsonBackReference("department")
    private Department department;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<EmployeePhone> employeePhones;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "employee_projects", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Project> projects;

    public void addEmployeePhone(EmployeePhone employeePhone) {
        if (getEmployeePhones() == null) {
            this.employeePhones = new ArrayList<>();
        }
        getEmployeePhones().add(employeePhone);
        employeePhone.setEmployee(this);
    }

    public void addProjectToEmploye(Project project) {
        if (getProjects() == null) {
            this.projects = new ArrayList<>();
        }
        if (!getProjects().contains(project)) {
            getProjects().add(project);
        }
    }
}
