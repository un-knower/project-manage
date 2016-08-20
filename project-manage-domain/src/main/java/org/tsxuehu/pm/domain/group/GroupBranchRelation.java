package org.tsxuehu.pm.domain.group;

import lombok.Data;

/**
 * Created by tsxuehu on 16/8/15.
 */
@Data
public class GroupBranchRelation {
    Long branchId;
    Long groupId;//构建分组id
    String buildTag;//对于git,这个值是构建的commit
}
