package com.company.model;

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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;

    private String password;

    private boolean admin;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Company> companies;

    public void addCompany(Company company) {
        if (getCompanies() == null) {
            this.companies = new ArrayList<>();
        }
        getCompanies().add(company);
        company.setUser(this);
    }
}
