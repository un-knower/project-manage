package org.tsxuehu.pm.dao.impl;

import org.springframework.stereotype.Repository;
import org.tsxuehu.pm.dao.BranchDao;
import org.tsxuehu.pm.dao.mapper.BranchDOMapper;
import org.tsxuehu.pm.domain.application.Branch;

import javax.annotation.Resource;
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

        return null;
    }

    @Override
    public void delete(String branchId) {

    }

    @Override
    public List<Branch> getProjectRelateBranch(Long id) {
        return null;
    }
}
