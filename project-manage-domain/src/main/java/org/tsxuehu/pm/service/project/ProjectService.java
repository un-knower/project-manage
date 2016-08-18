package org.tsxuehu.pm.service.project;

import org.springframework.stereotype.Service;
import org.tsxuehu.pm.dao.ProjectDao;
import org.tsxuehu.pm.domain.application.Branch;
import org.tsxuehu.pm.domain.project.Project;
import org.tsxuehu.pm.domain.user.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tsxuehu on 16/8/17.
 */
@Service("projectService")
public class ProjectService {

    @Resource
    ProjectDao projectDao;

    public Long createProject(String name, String description, Long creatorId, String creatorName) {
        return projectDao.create(new Project(null, name, description, new User(creatorId, creatorName)));
    }

    public void update(Long projectId, String developers, String testers, String codeReviewers) {
        Project project = new Project(projectId);
        project.setDevelopers(User.userListFromJSONString(developers));
        project.setTesters(User.userListFromJSONString(testers));
        project.setCodeReviewer(User.userListFromJSONString(codeReviewers));
        projectDao.update(project);

    }

    public List<Project> getAllProject() {
        return projectDao.getAllProject();
    }

    /**
     * 获取项目详情,也会获得项目的所有分支
     *
     * @param id
     * @return
     */
    public Project getProject(Long id) {
        return projectDao.getProject(id);
    }

    public Branch createBranch(Long applicationId, Long projectId, String name, String scmBranchName, String description,
                               String extra, String deployServer, Long creatorId, String creatorName) {
        return null;
    }

    public void deleteBranch(String branchId) {

    }

}
