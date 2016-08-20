package org.tsxuehu.pm.domain.environment;

import org.tsxuehu.pm.domain.application.Server;

import java.util.List;
import java.util.Map;

/**
 * 对付庞大应用专用的一个概念
 * Created by tsxuehu on 16/8/12.
 */
public class Group {

    public static final String DAILY = "daily";
    public static final String PRE = "pre";
    public static final String FORMAL = "formal";


    Long id;
    String name;
    String description;
    /**
     * 机器列表 , 作为参数传到推包脚本里
     */
    List<Server> servers;//要部署到的机器

    String integrationBranch;//集成分支
    String repositoryLocation;

    Long projectId;//项目环境中的group 会包含projectid
    Long branchId;//分支环境中的group 包含branchId
    Long applicationId;

    /**
     * 这个配置会作为参数 传递到构建脚本里
     * 构建脚本可以将键值对生成配置文件放到应用程序包中
     * 应用程序运行时,可以从配置文件里读到配置信息
     */
    Map<String, String> configuration;

    String type;//日常(和线上不同库)、预发(和线上同库)、正式(线上环境)。三种类型


    /**
     * 分支合并脚本合并分支时,会返回各个被合并分支的commit,然后保存到数据库里
     */
    List<GroupBranchRelation> groupBranchBuildStatuses;//需要的时候才会加载

    /**
     * 进度只是
     */
    //构建状态 正在做什么事,已经完成的比例
    String buildPhrase;
    int buidRate;
    //推送状态
    String pushPhrase;
    int pushRate;
}
