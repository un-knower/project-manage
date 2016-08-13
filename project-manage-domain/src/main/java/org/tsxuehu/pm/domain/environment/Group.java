package org.tsxuehu.pm.domain.environment;

import org.tsxuehu.pm.domain.application.Branch;

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
    String machine;

    List<Branch> branches;
}
