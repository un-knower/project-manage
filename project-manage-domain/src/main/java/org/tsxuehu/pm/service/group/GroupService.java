package org.tsxuehu.pm.service.group;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.tsxuehu.pm.dao.BranchDao;
import org.tsxuehu.pm.dao.GroupBranchRelationDao;
import org.tsxuehu.pm.dao.GroupDao;
import org.tsxuehu.pm.domain.application.Branch;
import org.tsxuehu.pm.domain.group.Group;
import org.tsxuehu.pm.domain.group.GroupBranchRelation;
import org.tsxuehu.pm.service.application.ApplicationService;
import org.tsxuehu.pm.service.scm.SCMService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by tsxuehu on 16/8/20.
 */
@Service("groupService")
public class GroupService {
    @Resource
    GroupDao groupDao;
    @Resource
    GroupBranchRelationDao groupBranchRelationDao;
    @Resource
    ApplicationService applicationService;
    @Resource
    SCMService scmService;
    @Resource
    BranchDao branchDao;

    public Long createGroup(String type, String name, String description, Long applicationId, Long projectId, Long branchId) {
        Group group = new Group(null, type, name, description, applicationId, projectId, branchId);
        //生成仓库地址
        group.setRepositoryLocation(applicationService.getRepositoryLocation(applicationId));
        return groupDao.create(group);
    }

    public void updateGroup(Long groupId, String description, String configuration) {
        Group group = new Group(groupId);
        group.setDescription(description);
        group.setConfiguration(JSON.parseObject(configuration, Map.class));
        groupDao.update(group);

    }

    public Group getGroupStatus(Long groupId) {
        return groupDao.getGroup(groupId);
    }

    public Group getGroup(Long groupId) {
        Group group = groupDao.getGroup(groupId);
        List<GroupBranchRelation> branchRelations = groupBranchRelationDao.getGroupRelatedBranches(groupId);
       
        List<Branch> branches = branchDao.getBranchList(Lists.transform(branchRelations, new Function<GroupBranchRelation, Long>() {
            @Override
            public Long apply(GroupBranchRelation groupBranchRelation) {
                return groupBranchRelation.getBranchId();
            }
        }));
        group.setRelatedBranches(branches);
        return group;
    }

    //取出信息,执行脚本
    public void buildGroup(Long groupId) {
        //检查集成分支,没有则创建

        //通过后台线程去执行构建

    }

    /**
     * 更新执行状态
     */
    public void updateBuildStatus() {

    }

    /**
     * @param groupId
     * @param branchStrIds branchId数组
     */
    public void addBranch(final Long groupId, String branchStrIds) {
        final List<Long> branchIds = JSON.parseObject(branchStrIds, List.class);

        groupBranchRelationDao.addBranch(Lists.transform(branchIds, new Function<Long, GroupBranchRelation>() {
            @Override
            public GroupBranchRelation apply(Long id) {
                return new GroupBranchRelation(id, groupId, null);
            }
        }));
    }

    public void removeBranch(Long groupId, Long branchId) {
        //删除分支需要将集成分支删除
        Group group = groupDao.getGroup(groupId);
        group.setNeedReintegration(true);
        groupDao.update(group);
        groupBranchRelationDao.remove(groupId, branchId);
    }

    /**
     * 获取项目的所有分组,分组里的分支
     *
     * @param projectId
     * @return
     */
    public List<Group> getAllProjectGroup(Long projectId, String type) {

        List<Group> groups = getGroupList(null, projectId, null, type);
        return groups;
    }

    public List<Group> getAllApplicationGroup(Long applicationId, String type) {
        return getGroupList(applicationId, null, null, type);
    }

    public List<Group> getAllBranchGroup(Long branchId, String type) {
        return getGroupList(null, null, branchId, type);
    }

    private List<Group> getGroupList(Long applicationId, Long projectId, Long branchId, String type) {
        return groupDao.getGroupList(applicationId, projectId, branchId, type);
    }

}
