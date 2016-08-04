package org.tsxuehu.pm.domain.application;

import org.tsxuehu.pm.domain.application.scm.Branch;

import java.util.Date;
import java.util.List;

/**
 * 项目、日常、预发、线上
 * Created by tsxuehu on 16/7/22.
 */
public class Environment {
    long id;
    List<Branch> branches;//在该环境中部署的分支
    Date createTime;

}
