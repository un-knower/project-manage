package org.tsxuehu.pm.domain.application;

import org.tsxuehu.pm.domain.application.scm.Branch;

import java.util.List;

/**
 * Created by tsxuehu on 16/7/25.
 */
public class BuildStatus {
    List<Branch> buidingBranch;
    List<Branch> developingBranch;
    int packageProgress;//打包进度
    String packagePhrase;//打包阶段
    int deployProgress;//0~100之间的值表示进度
    String deployPhrase;//构建阶段
}
