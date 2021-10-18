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
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String location;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @ManyToOne
    @JsonBackReference(value = "user")
    private User user;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "company")
    private List<Department> departments;

    public void addDepartment(Department department)
    {
        if (getDepartments() == null)
        {
            this.departments = new ArrayList<>();
        }
        getDepartments().add(department);
        department.setCompany(this);
    }

}
