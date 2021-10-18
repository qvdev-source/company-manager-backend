package com.company.service;

import com.company.model.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {

    Project addProjectToEmployee(long idEmployee, long idProject);

    Project addProjectToDeprtment(Project project, long id);

    Project editProject(Project project, long id);

    Project findProject(long id);

    void deleteProject(long id);

    List<Project> findProjectsForEmplopyee(long id);

    List<Project> findProjects();

    void deleteProjectFromEmployee(long idEmployee, long idProject);

}
