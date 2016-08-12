package org.tsxuehu.pm.domain.application;

/**
 * 项目拉的分支
 * Created by tsxuehu on 16/7/22.
 */
public class Branch {
    protected long id;
    protected String name;//人度的名字,说明分支干什么用的
    protected String branchId;//gitlab上的分支名
    protected String description;
}
