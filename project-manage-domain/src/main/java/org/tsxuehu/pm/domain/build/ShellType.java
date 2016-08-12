package org.tsxuehu.pm.domain.build;

/**
 * Created by tsxuehu on 16/8/12.
 */
public enum  ShellType {
    createBranch("createBranch","创建分支"),
    Merge("merge","合并分支"),
    Build("build","构建应用"),
    Push("push","推送应用");

    private ShellType(String key,String name){
        this.key = key;
        this.name = name;
    }

    private String key;
    private String name;
}
