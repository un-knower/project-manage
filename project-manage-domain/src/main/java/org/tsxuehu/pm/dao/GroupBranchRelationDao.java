package org.tsxuehu.pm.dao;

import org.tsxuehu.pm.domain.group.GroupBranchRelation;

import java.util.List;

/**
 * Created by tsxuehu on 16/8/20.
 */
public interface GroupBranchRelationDao {
    List<GroupBranchRelation> getGroupRelatedBranches(Long groupId);

    void remove(Long groupId, Long branchId);

    void addBranch(List<GroupBranchRelation> groupBranchRelations);
}
