package org.tsxuehu.pm.domain.project;

import lombok.Data;
import org.tsxuehu.pm.domain.application.Application;
import org.tsxuehu.pm.domain.application.Branch;
import org.tsxuehu.pm.domain.user.User;

import java.util.List;
import java.util.Map;

/**
 * 表示一个项目,包含
 * 1、任务分解、任务跟踪;(通过kityminder-editor在绘制任务),提供任务仪表图
 * 2、实现项目需要开发的分支(分支关联到引用);
 * 3、项目测试bug、质量跟踪;
 * 4、日常、预发部署,线上发布
 * <p>
 * Created by tsxuehu on 16/7/21.
 */
@Data
public class Project {

    public Project(Long id, String name, String description, User creator) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creator = creator;
    }
    public Project(Long id) {
        this.id = id;
    }

    Long id;
    String name;
    String description;

    protected User creator;//项目owner,pm

    protected List<User> developers;//开发人员

    protected List<User> testers;//测试人员

    protected List<User> codeReviewer;//code review人员

    /**
     * 开发分支列表
     */
     List<Branch> branches;

    /**
     * 创建分支
     */
    public void createBranch(String appName, String branchName, String useExitBranch) {


    }

}
