package org.tsxuehu.pm.dao.impl;

import org.springframework.stereotype.Repository;
import org.tsxuehu.pm.dao.GroupBranchRelationDao;
import org.tsxuehu.pm.dao.dbobject.GroupBranchRelationDO;
import org.tsxuehu.pm.dao.dbobject.GroupBranchRelationDOExample;
import org.tsxuehu.pm.dao.dbobject.GroupBranchRelationDOKey;
import org.tsxuehu.pm.dao.mapper.GroupBranchRelationDOMapper;
import org.tsxuehu.pm.domain.group.GroupBranchRelation;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tsxuehu on 16/8/21.
 */
@Repository("groupBranchRelationDao")
public class GroupBranchRelationDaoImpl implements GroupBranchRelationDao {

    @Resource
    GroupBranchRelationDOMapper groupBranchRelationDOMapper;

    @Override
    public List<GroupBranchRelation> getGroupRelatedBranches(Long groupId) {
        GroupBranchRelationDOExample example=new GroupBranchRelationDOExample();
        example.or().andGroupidEqualTo(groupId);
        return convert(groupBranchRelationDOMapper.selectByExample(example));
    }

    @Override
    public void remove(Long groupId, Long branchId) {
        GroupBranchRelationDOKey key = new GroupBranchRelationDOKey();
        key.setGroupid(groupId);
        key.setBranchid(branchId);
        groupBranchRelationDOMapper.deleteByPrimaryKey(key);
    }

    @Override
    public void addBranch(List<GroupBranchRelation> groupBranchRelations) {
        for (GroupBranchRelation groupBranchRelation : groupBranchRelations) {
            groupBranchRelationDOMapper.insert(convert(groupBranchRelation));
        }
    }

    private GroupBranchRelationDO convert(GroupBranchRelation groupBranchRelation) {
        GroupBranchRelationDO groupBranchRelationDO = new GroupBranchRelationDO();
        groupBranchRelationDO.setBuildTag(groupBranchRelation.getBuildTag());
        groupBranchRelationDO.setBranchid(groupBranchRelation.getBranchId());
        groupBranchRelationDO.setGroupid(groupBranchRelation.getGroupId());
        return groupBranchRelationDO;

    }

    private List<GroupBranchRelation> convert(List<GroupBranchRelationDO> groupBranchRelationDOs) {
        List<GroupBranchRelation> groupBranchRelations = new ArrayList<>(groupBranchRelationDOs.size());
        for (GroupBranchRelationDO groupBranchRelationDO : groupBranchRelationDOs) {
            groupBranchRelations.add(
                    new GroupBranchRelation(groupBranchRelationDO.getBranchid(),
                            groupBranchRelationDO.getGroupid(), groupBranchRelationDO.getBuildTag())
            );
        }
        return groupBranchRelations;

    }
}
