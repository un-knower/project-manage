package org.tsxuehu.pm.project;

import org.tsxuehu.pm.application.scm.Branch;
import org.tsxuehu.pm.business.Requirement;
import org.tsxuehu.pm.project.task.Task;
import org.tsxuehu.pm.project.task.TaskPicture;
import org.tsxuehu.pm.user.User;

import java.util.List;
import java.util.Map;

/**
 * 表示一个项目,包含
 * 1、任务分解、任务跟踪;(通过kityminder-editor在绘制任务),提供任务仪表图
 * 2、实现项目需要开发的分支(分支关联到引用);
 * 3、项目测试bug、质量跟踪;
 * 4、日常、预发部署,线上发布
 *
 * Created by tsxuehu on 16/7/21.
 */
public class Project {
    protected User owner;//项目owner,pm

    protected List<Requirement> requirements;//项目需要完成的需求

    protected TaskPicture taskPicture;//任务分解图

    protected Map<User,List<Task>> userTasks;//项目相关人员的任务列表

    protected List<User> developers;//开发人员

    protected List<User> testers;//测试人员

    protected List<Branch> branches;//项目关联的分支

    /**
     * 创建分支
     */
    public void createBranch(String appName,String branchName,String useExitBranch){


    }
}
