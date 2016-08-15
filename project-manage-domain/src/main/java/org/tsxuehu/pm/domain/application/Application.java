package org.tsxuehu.pm.domain.application;

import org.tsxuehu.pm.domain.user.User;

import java.util.Date;
import java.util.List;

/**
 *
 * Created by tsxuehu on 16/7/22.
 */

public class Application {

    Long id;
    String name;//全局唯一
    String description;

    Long scmId;//git仓库地址
    String gitlabProjectId;//工程在gitlab上的id

    List<Server> dailyMachines;//日常可部署机器
    List<Server> preMachines;//预发可部署机器
    List<Server> formalMachines;//部署时部署的机器

    User owner;

    List<User> publishers;//可发布人员

    long mergeShellId;//合并分支的脚本id
    long buildShellId;//构建脚本id
    long publishShellId;//发布脚本id

    /**
     * review项(代码质量保证 选项)
     */
    boolean mustCodeReview;//必须通过review才能上线
    boolean mustTest;//必须通过测试才能上线
    boolean mustStaticScan;//必须通过静态扫描才能上线

    /**
     * 执行构建脚本时,appParam会传递给脚本
     */
    String appParam;

}
