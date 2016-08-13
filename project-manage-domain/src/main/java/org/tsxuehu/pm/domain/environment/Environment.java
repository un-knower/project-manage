package org.tsxuehu.pm.domain.environment;

import java.util.Map;

/**
 * 环境里面有很多分支分组,不同的租可以构建到不同的机器上
 * Created by tsxuehu on 16/8/12.
 */
public class Environment {
    /**
     *   这个配置会作为参数 传递到构建脚本里
     *   构建脚本可以将键值对生成配置文件放到应用程序包中
     *   应用程序运行时,可以从配置文件里读到配置信息
     */
    Map<String,String> configuration;
}
