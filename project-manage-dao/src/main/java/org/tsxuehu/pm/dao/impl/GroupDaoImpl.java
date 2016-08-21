package org.tsxuehu.pm.dao.impl;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Repository;
import org.tsxuehu.pm.dao.GroupDao;
import org.tsxuehu.pm.dao.dbobject.GroupDO;
import org.tsxuehu.pm.dao.dbobject.GroupDOExample;
import org.tsxuehu.pm.dao.mapper.GroupDOMapper;
import org.tsxuehu.pm.domain.application.Server;
import org.tsxuehu.pm.domain.group.Group;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tsxuehu on 16/8/21.
 */
@Repository("groupDao")
public class GroupDaoImpl implements GroupDao {
    @Resource
    GroupDOMapper groupDOMapper;

    @Override
    public Long create(Group group) {
        GroupDO groupDO = convert(group);
        groupDOMapper.insert(groupDO);
        return groupDO.getId();
    }

    @Override
    public void update(Group group) {
        groupDOMapper.updateByPrimaryKeySelective(convert(group));
    }

    @Override
    public Group getGroup(Long groupId) {
        return convert(groupDOMapper.selectByPrimaryKey(groupId));
    }

    @Override
    public List<Group> getGroupList(Long applicationId, Long projectId, Long branchId, String type) {
        GroupDOExample example = new GroupDOExample();
        GroupDOExample.Criteria criteria = example.or();
        if (applicationId != null) {
            criteria.andApplicationidEqualTo(applicationId);
        } else {
            criteria.andApplicationidIsNull();
        }

        if (projectId != null) {
            criteria.andProjectidEqualTo(projectId);
        } else {
            criteria.andProjectidIsNull();
        }
        if (branchId != null) {
            criteria.andBranchidEqualTo(branchId);
        } else {
            criteria.andBranchidIsNull();
        }
        criteria.andTypeEqualTo(type);
        return convert(groupDOMapper.selectByExample(example));
    }

    private GroupDO convert(Group group) {
        GroupDO groupDO = new GroupDO();
        groupDO.setId(group.getId());
        groupDO.setName(group.getName());
        groupDO.setDescription(group.getDescription());
        groupDO.setType(group.getType());
        groupDO.setApplicationid(group.getApplicationId());
        groupDO.setBranchid(group.getBranchId());
        groupDO.setProjectid(group.getProjectId());
        groupDO.setConfiguration(JSON.toJSONString(group.getConfiguration()));
        groupDO.setServers(group.getServers() == null ? null :
                Server.toJSONString(group.getServers()));
        groupDO.setIntegrationbranch(group.getIntegrationBranch());
        groupDO.setNeedreintegration(
                group.getNeedReintegration() != null && group.getNeedReintegration() == true ? (byte) 1 : (byte) 0);
        groupDO.setRepositorylocation(group.getRepositoryLocation());
        groupDO.setBuidrate(group.getBuildRate());
        groupDO.setBuildphrase(group.getBuildPhrase());
        groupDO.setPushphrase(group.getPushPhrase());
        groupDO.setPushrate(group.getPushRate());
        return groupDO;
    }

    private Group convert(GroupDO groupDO) {
        Group group = new Group(groupDO.getId(),
                groupDO.getType(), groupDO.getName(), groupDO.getDescription(),
                groupDO.getApplicationid(), groupDO.getProjectid(), groupDO.getBranchid());
        group.setNeedReintegration(
                groupDO.getNeedreintegration() != null && groupDO.getNeedreintegration() == 1 ? true : false);
        group.setPushRate(groupDO.getPushrate());
        group.setPushPhrase(groupDO.getPushphrase());
        group.setBuildRate(groupDO.getBuidrate());
        group.setBuildPhrase(groupDO.getBuildphrase());
        group.setType(groupDO.getType());
        group.setRepositoryLocation(groupDO.getRepositorylocation());
        group.setIntegrationBranch(groupDO.getIntegrationbranch());
        group.setServers(Server.serverListFromJSONString(groupDO.getServers()));
        return group;
    }

    private List<Group> convert(List<GroupDO> groupDOs) {
        List<Group> groups = new ArrayList<>(groupDOs.size());
        for (GroupDO groupDO : groupDOs) {
            groups.add(new Group(groupDO.getId(),
                    groupDO.getType(), groupDO.getName(), groupDO.getDescription(),
                    groupDO.getApplicationid(), groupDO.getProjectid(), groupDO.getBranchid()));
        }
        return groups;
    }
}
