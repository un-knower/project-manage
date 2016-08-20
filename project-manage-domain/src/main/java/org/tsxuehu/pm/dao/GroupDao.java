package org.tsxuehu.pm.dao;

import org.tsxuehu.pm.domain.group.Group;

import java.util.List;

/**
 * Created by tsxuehu on 16/8/20.
 */
public interface GroupDao {
    Long create(Group group);

    void update(Group group);

    Group getGroup(Long groupId);

    List<Group> getGroupList(Long applicationId, Long projectId,Long branchId, String type);
}
