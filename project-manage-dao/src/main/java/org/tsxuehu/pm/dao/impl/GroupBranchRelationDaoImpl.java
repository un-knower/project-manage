package org.tsxuehu.pm.dao.impl;

import org.tsxuehu.pm.dao.GroupBranchRelationDao;
import org.tsxuehu.pm.domain.group.GroupBranchRelation;

import java.util.List;

/**
 * Created by tsxuehu on 16/8/21.
 */
public class GroupBranchRelationDaoImpl implements GroupBranchRelationDao {
    @Override
    public List<GroupBranchRelation> getGroupRelatedBranches(Long groupId) {
        return null;
    }

    @Override
    public void remove(Long groupId, Long branchId) {

    }

    @Override
    public void addBranch(Long groupId, List<Long> branchIds) {

    }
}
