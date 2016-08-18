package org.tsxuehu.pm.dao;

import org.tsxuehu.pm.domain.project.Project;

import java.util.List;

/**
 * Created by tsxuehu on 16/8/14.
 */
public interface ProjectDao {

    Long create(Project project);


    void update(Project project);

    List<Project> getAllProject();

    Project getProject(Long id);
}
