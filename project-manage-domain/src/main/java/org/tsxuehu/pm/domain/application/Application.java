package org.tsxuehu.pm.domain.application;

import org.gitlab.api.GitlabAPI;
import org.tsxuehu.pm.domain.application.scm.Branch;
import org.tsxuehu.pm.domain.application.scm.Credential;
import org.tsxuehu.pm.domain.application.scm.SCMType;
import org.tsxuehu.pm.domain.user.User;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 引用类型包括前端、后端(php、java)、无线(ios、Android);
 * Created by tsxuehu on 16/7/22.
 */
public class Application {

    public static final String MAVEN_PROJECT="maven";


    public static final String PRIVATE_TOKEN = "2iAZn7fTUjKV9xsiS4KR";
    public static final String GITLAB_HOST = "http://gitlab.qima-inc.com/";


    Long id;
    String name;
    String description;
    String appType;

    Long ownerId;//应用所有人id
    String ownerNick;//应用所有人昵称
    //授权

    //仓库的gitlab的project id(第一期只支持gitlab,且只有一个仓库地址。 用project id标识)
    protected String gitlabId;//格式NAMESPACE/PROJECT_NAME

    protected List<Branch> developingBranches;//所有正在开发的分支
    protected List<Branch> dailyBranches;//所有进入日常的分支
    protected List<Branch> preBranches;//所有进入预发的分支
    protected List<Branch> onlineBranches;//所有进入线上的分支

    protected String dailyDeployBranchName;//日常部署分支名
    protected boolean isDailyFree;//日常环境是否空间,没有正在构建

    protected String preDeployBranchName;//预发部署分支名
    protected boolean isPreFree;//预发环境是否空间,没有正在构建

    /**
     * 通过子类构造创建
     *
     * @param name
     * @param
     * @param creator
     */
    public static void createApplication(String name, String description,User creator) {

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
        gitlabAPI.createBranch(gitlabId, actualBranchName, fromBranch);
        return actualBranchName;
    }

    public void deleteBranche() {

    }

    public void enterDaily(long branchId){

    }

    public void removeDailyBranches(long branchId){

    }

    public void buidDaily(){

    }

    /**
     * 获取日常构建状态
     */
    public BuildStatus getDailyStatus(){
        //所有分支
        //进入日常的分支
        //构建、部署进度
        return null;

    }

    public void enterPre(){

    }

    public void removePreBranches(){

    }

    public void buidPre(){

    }

    public void enterOnlineBranches(){

    }

    public void removeOnlineBranches(){

    }

    public void buidOnline(){

    }
}
