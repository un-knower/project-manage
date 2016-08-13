package org.tsxuehu.pm.domain.application;

/**
 * 项目拉的分支
 * Created by tsxuehu on 16/7/22.
 */
public class Branch {
    protected Long id;
    protected String name;//人度的名字,说明分支干什么用的
    protected String branchId;//gitlab上的分支名
    protected String description;//可以修改
    protected String extra;//可以修改
    protected String deployLocation;//分支单独部署的机器
}
