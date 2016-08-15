package org.tsxuehu.pm.domain.environment;

import org.tsxuehu.pm.domain.application.Branch;
import org.tsxuehu.pm.domain.application.Server;

import java.util.List;
import java.util.Map;

/**
 * 对付庞大应用专用的一个概念
 * Created by tsxuehu on 16/8/12.
 */
public class Group {
    /**
     *  这里的配置会改写环境中设置的配置
     */
    Map<String,String> configuration;
    /**
     * 机器列表 , 作为参数传到推包脚本里
     */
    List<Server> servers;//要部署到的机器

    String integrationBranch;//集成分支

    List<BranchBuildStatus> branchBuildStatuses;

    //构建状态
    String buildPhrase;
    int buidRate;
    //推送状态
    String pushPhrase;
    String pushRate;
}
