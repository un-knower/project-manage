package org.tsxuehu.pm.domain.application;

import org.tsxuehu.pm.domain.user.User;

/**
 * 项目拉的分支
 * Created by tsxuehu on 16/7/22.
 */
public class Branch {
    Long id;
    String name;//人度的名字,说明分支干什么用的
    String scmBranchId;//gitlab上的分支名
    Long applicationId;
    Long projectId;
    String description;//可以修改
    String extra;//可以修改
    String deployLocation;//分支单独部署的机器
    User creator;
}
