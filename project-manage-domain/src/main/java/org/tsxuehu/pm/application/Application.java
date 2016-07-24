package org.tsxuehu.pm.application;

import org.gitlab.api.GitlabAPI;
import org.tsxuehu.pm.application.scm.Branch;
import org.tsxuehu.pm.application.scm.Credential;
import org.tsxuehu.pm.application.scm.SCMType;
import org.tsxuehu.pm.user.User;

import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 引用类型包括前端、后端(php、java)、无线(ios、Android);
 * Created by tsxuehu on 16/7/22.
 */
public class Application {

    public static final String PRIVATE_TOKEN = "2iAZn7fTUjKV9xsiS4KR";
    public static final String GITLAB_HOST = "http://gitlab.qima-inc.com/";

    String ownerId;//应用所有人id
    String ownerNick;//应用所有人昵称
    //授权

    //仓库的gitlab的project id(第一期只支持gitlab,且只有一个仓库地址。 用project id标识)
    protected String projectId;//格式NAMESPACE/PROJECT_NAME

    protected List<Branch> developingBranches;//所有正在开发的分支
    protected List<Branch> dailyBranches;//所有进入日常的分支
    protected List<Branch> preBranches;//所有进入预发的分支

    /**
     * 通过子类构造创建
     *
     * @param name
     * @param applicationType
     * @param creator
     */
    public static void createApplication(String name, ApplicationType applicationType, User creator) {

    }

    /**
     * 获取所有应用类型
     *
     * @return
     */
    public static List<ApplicationType> getAllApplicationType() {
        return null;
    }

    /**
     * 获取用户user创建的所有引用
     *
     * @param user
     * @return
     */
    public static List<Application> getApplication(User user, int pageNo, int pageSize) {
        return null;
    }

    /**
     * 获取一个应用详细信息
     *
     * @param appName
     * @return
     */
    public Application getApplication(String appName) {
        return null;
    }


    //设置应用代码库地址
    public void setSCM(SCMType type, String url, Credential credential) {

    }

    /**
     * 设置应用所在的机器
     */
    public void setMachine() {

    }

    /**
     * 从fromBranch拉去一个新分支,新分支名为newBranchName+当前时间戳
     *
     * @param newBranchName
     * @param fromBranch
     */
    public String createNewBranchInGitLab(String newBranchName, String fromBranch) throws IOException {
        long now = System.currentTimeMillis();
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy_MM_dd_HHmmssSSS");
        Date date = new Date();
        String actualBranchName = newBranchName + "_" + dateFormater.format(date);
        GitlabAPI gitlabAPI = GitlabAPI.connect(Application.GITLAB_HOST, Application.PRIVATE_TOKEN);
        gitlabAPI.createBranch(projectId, actualBranchName, fromBranch);
        return actualBranchName;
    }

    public void deleteBranche() {

    }
}
