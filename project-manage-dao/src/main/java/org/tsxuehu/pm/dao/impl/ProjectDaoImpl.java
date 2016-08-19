package org.tsxuehu.pm.dao.impl;

import org.springframework.stereotype.Repository;
import org.tsxuehu.pm.dao.ProjectDao;
import org.tsxuehu.pm.dao.dbobject.ProjectDO;
import org.tsxuehu.pm.dao.dbobject.ProjectDOExample;
import org.tsxuehu.pm.dao.mapper.ProjectDOMapper;
import org.tsxuehu.pm.domain.project.Project;
import org.tsxuehu.pm.domain.user.User;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tsxuehu on 16/8/20.
 */
@Repository("projectDao")
public class ProjectDaoImpl implements ProjectDao {

    @Resource
    ProjectDOMapper projectDOMapper;

    @Override
    public Long create(Project project) {
        ProjectDO projectDO = convert(project);
        projectDOMapper.insert(projectDO);
        return projectDO.getId();
    }

    @Override
    public void update(Project project) {
        ProjectDO projectDO = convert(project);
        projectDOMapper.updateByPrimaryKeySelective(projectDO);
    }

    @Override
    public List<Project> getAllProject() {
        ProjectDOExample example = new ProjectDOExample();
        return convert(projectDOMapper.selectByExample(example));
    }

    @Override
    public Project getProject(Long id) {
        return convert(projectDOMapper.selectByPrimaryKey(id));
    }

    private ProjectDO convert(Project project) {
        ProjectDO projectDO = new ProjectDO();
        projectDO.setId(project.getId());
        projectDO.setName(project.getName());
        projectDO.setDescription(project.getDescription());
        projectDO.setCreator(project.getCreator().toJSONString());
        projectDO.setDevelopers(project.getDevelopers() == null ? null : User.toJSONString(project.getDevelopers()));
        projectDO.setTesters(project.getTesters() == null ? null : User.toJSONString(project.getTesters()));
        projectDO.setCodereviewer(project.getCodeReviewer() == null ? null : User.toJSONString(project.getCodeReviewer()));
        return projectDO;
    }

    private Project convert(ProjectDO projectDO) {
        Project project = new Project(projectDO.getId(), projectDO.getName(),
                projectDO.getDescription(), User.userFromJSONString(projectDO.getCreator()));
        project.setDevelopers(User.userListFromJSONString(projectDO.getDevelopers()));
        project.setTesters(User.userListFromJSONString(projectDO.getTesters()));
        project.setCodeReviewer(User.userListFromJSONString(projectDO.getCodereviewer()));
        return project;
    }

    private List<Project> convert(List<ProjectDO> projectDOs) {
        List<Project> projects = new ArrayList<>(projectDOs.size());
        for (ProjectDO projectDO : projectDOs) {
            projects.add(new Project(projectDO.getId(), projectDO.getName(),
                    projectDO.getDescription(), User.userFromJSONString(projectDO.getCreator())));
        }
        return projects;
    }
}
