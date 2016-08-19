package org.tsxuehu.pm.domain.application;

import lombok.Data;
import org.tsxuehu.pm.domain.user.User;

/**
 * 项目拉的分支
 * Created by tsxuehu on 16/7/22.
 */
@Data
public class Branch {
    public Branch(Long id, String name, String scmBranchId, String description,String repositoryLocation) {
        this.id = id;
        this.name = name;
        this.scmBranchId = scmBranchId;
        this.description = description;
        this.repositoryLocation = repositoryLocation;
    }

    Long id;
    String name;//人度的名字,说明分支干什么用的
    String scmBranchId;//gitlab上的分支名
    String repositoryLocation;//仓库地址
    Long applicationId;
    Long projectId;
    String description;//可以修改
    String extra;//附加信息,创给打包脚本
    Server deployServer;//分支单独部署的机器
    String checkoutPoint;//拉分支时的commit
    User creator;
}
