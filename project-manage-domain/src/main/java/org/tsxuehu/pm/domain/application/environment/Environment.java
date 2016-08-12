package org.tsxuehu.pm.domain.application.environment;

import java.util.Map;

/**
 * 环境里面有很多分支分组,不同的租可以构建到不同的机器上
 * Created by tsxuehu on 16/8/12.
 */
public class Environment {
    //这个配置信息生成配置文件,然后加入到分支打包后的压缩包里
    Map<String,String> configuration;
}
