package org.tsxuehu.pm.dao.impl;

import org.springframework.stereotype.Repository;
import org.tsxuehu.pm.dao.BranchDao;
import org.tsxuehu.pm.dao.dbobject.BranchDO;
import org.tsxuehu.pm.dao.dbobject.BranchDOExample;
import org.tsxuehu.pm.dao.dbobject.ProjectDO;
import org.tsxuehu.pm.dao.mapper.BranchDOMapper;
import org.tsxuehu.pm.domain.application.Branch;
import org.tsxuehu.pm.domain.application.Server;
import org.tsxuehu.pm.domain.project.Project;
import org.tsxuehu.pm.domain.user.User;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tsxuehu on 16/8/20.
 */
@Repository("branchDao")
public class BranchDaoImpl implements BranchDao {

    @Resource
    BranchDOMapper branchDOMapper;

    @Override
    public Long create(Branch branch) {
        BranchDO branchDO = convert(branch);
        branchDOMapper.insert(branchDO);

        return branchDO.getId();
    }

    @Override
    public void delete(Long branchId) {
        branchDOMapper.deleteByPrimaryKey(branchId);
    }

    @Override
    public List<Branch> getProjectRelateBranch(Long id) {
        BranchDOExample example =new BranchDOExample();
        example.or().andProjectidEqualTo(id);
        return convert(branchDOMapper.selectByExample(example));
    }

    @Override
    public Branch getBranch(Long branchId) {
        return convert(branchDOMapper.selectByPrimaryKey(branchId));
    }

    private BranchDO convert(Branch branch) {
        BranchDO branchDO = new BranchDO();
        branchDO.setId(branch.getId());
        branchDO.setName(branch.getName());
        branchDO.setScmbranchid(branch.getScmBranchId());
        branchDO.setDescription(branch.getDescription());
        branchDO.setRepositorylocation(branch.getRepositoryLocation());
        branchDO.setApplicationid(branch.getApplicationId());
        branchDO.setProjectid(branch.getProjectId());
        branchDO.setExtra(branch.getExtra());
        branchDO.setDeployserver(branch.getDeployServer() == null ?
                null : branch.getDeployServer().toJSONString());
        branchDO.setCheckoutpoint(branch.getCheckoutPoint());
        branchDO.setCreator(branch.getCreator().toJSONString());
        return branchDO;
    }

    private Branch convert(BranchDO branchDO) {
        Branch branch = new Branch(branchDO.getId(), branchDO.getName(),
                branchDO.getScmbranchid(), branchDO.getDescription(), branchDO.getRepositorylocation());
        branch.setCheckoutPoint(branchDO.getCheckoutpoint());
        branch.setApplicationId(branchDO.getApplicationid());
        branch.setProjectId(branchDO.getProjectid());
        branch.setExtra(branchDO.getExtra());
        branch.setDeployServer(Server.serverFromJSONString(branchDO.getDeployserver()));
        branch.setCreator(User.userFromJSONString(branchDO.getCreator()));
        return branch;
    }

    private List<Branch> convert(List<BranchDO> branchDOs) {
        List<Branch> branches = new ArrayList<>(branchDOs.size());
        for (BranchDO branchDO : branchDOs) {
            branches.add(new Branch(branchDO.getId(), branchDO.getName(),
                    branchDO.getScmbranchid(), branchDO.getDescription(), branchDO.getRepositorylocation()));
        }
        return branches;
    }
}
