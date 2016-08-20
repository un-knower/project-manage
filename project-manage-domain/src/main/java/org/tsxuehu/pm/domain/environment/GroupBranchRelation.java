package org.tsxuehu.pm.domain.environment;

/**
 * Created by tsxuehu on 16/8/15.
 */
public class GroupBranchRelation {
    Long branchId;
    Long groupId;//构建分组id
    String buildTag;//对于git,这个值是构建的commit
}
