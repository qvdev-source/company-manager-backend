package com.company.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String code;

    private String location;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @ManyToOne
    @JsonBackReference(value = "company")
    private Company company;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Employee> employees;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Project> projects;

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void addEmployee(Employee employee) {
        if(getEmployees() == null) {
            this.employees = new ArrayList<>();
        }
        getEmployees().add(employee);
        employee.setDepartment(this);
    }

    public void addProjectToDepratment(Project project) {
        if(getProjects() == null) {
            this.projects = new ArrayList<>();
        }
        getProjects().add(project);
        project.setDepartment(this);
    }
}
