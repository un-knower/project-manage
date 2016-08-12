package org.tsxuehu.pm.domain.application;

import org.tsxuehu.pm.domain.user.User;

import java.util.List;

/**
 *
 * Created by tsxuehu on 16/7/22.
 */
public class Application {

    Long id;
    String name;
    String description;

    long scmId;//git仓库地址
    String projectId;//工程id
    String scmPath;//作为参数传给合并分支的脚本

    List<Server> dailyMachines;//日常可部署机器
    List<Server> preMachines;//预发可部署机器
    List<Server> formalMachines;//部署时部署的机器


    User owner;

    List<User> publisher;//可发布人员

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
     * 设置应用所在的机器
     */
    public void setMachine() {

    }


    public void deleteBranche() {

    }

    public void enterDaily(long branchId) {

    }

    public void removeDailyBranches(long branchId) {

    }

    public void buidDaily() {

    }

    /**
     * 获取日常构建状态
     */
    public BuildStatus getDailyStatus() {
        //所有分支
        //进入日常的分支
        //构建、部署进度
        return null;

    }

    public void enterPre() {

    }

    public void removePreBranches() {

    }

    public void buidPre() {

    }

    public void enterOnlineBranches() {

    }

    public void removeOnlineBranches() {

    }

    public void buidOnline() {

    }
}
