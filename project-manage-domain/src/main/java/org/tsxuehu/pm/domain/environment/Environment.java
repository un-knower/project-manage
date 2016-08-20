package org.tsxuehu.pm.domain.environment;

import java.util.Map;

/**
 * 环境里面有很多分支分组,不同的租可以构建到不同的机器上
 * Created by tsxuehu on 16/8/12.
 */
public class Environment {

    Map<String,String> configuration;
}
