package org.tsxuehu.pm.service.project;

import org.springframework.stereotype.Service;
import org.tsxuehu.pm.dao.BranchDao;
import org.tsxuehu.pm.dao.ProjectDao;
import org.tsxuehu.pm.domain.application.Application;
import org.tsxuehu.pm.domain.application.Branch;
import org.tsxuehu.pm.domain.application.Server;
import org.tsxuehu.pm.domain.project.Project;
import org.tsxuehu.pm.domain.scm.SCM;
import org.tsxuehu.pm.domain.user.User;
import org.tsxuehu.pm.service.application.ApplicationService;
import org.tsxuehu.pm.service.scm.SCMService;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by tsxuehu on 16/8/17.
 */
@Service("projectService")
public class ProjectService {

    @Resource
    ProjectDao projectDao;

    @Resource
    ApplicationService applicationService;

    @Resource
    SCMService scmService;
    @Resource
    BranchDao branchDao;

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
        Project project = projectDao.getProject(id);
        List<Branch> branches = branchDao.getProjectRelateBranch(id);
        project.setBranches(branches);

        return project;
    }

    public Branch createBranch(Long applicationId, Long projectId, String name, String scmBranchName, String fromScmBranch, String description,
                               String extra, String deployServer, Long creatorId, String creatorName) throws IOException {

        //查询应用获取scm
        Application application = applicationService.getApplication(applicationId);
        SCM scm = scmService.getSCM(application.getScmId());
        //通过scm创建分支
        String actualBranchName = scm.createNewBranch(application.getGitlabProjectId(), scmBranchName, fromScmBranch);
        //将分支写入数据库
        Branch branch = new Branch(null, name, scmBranchName, description,
                scm.getRepositoryLocation(application.getGitlabProjectId()));
        branch.setApplicationId(applicationId);
        branch.setProjectId(projectId);
        branch.setExtra(extra);
        branch.setDeployServer(Server.serverFromJSONString(deployServer));
        branch.setCreator(new User(creatorId, creatorName));
        Long branchId = branchDao.save(branch);
        branch.setId(branchId);
        return branch;
    }

    public void deleteBranch(String branchId) {
        branchDao.delete(branchId);
    }

}
