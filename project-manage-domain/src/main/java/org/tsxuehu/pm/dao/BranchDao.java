package org.tsxuehu.pm.dao;

import org.tsxuehu.pm.domain.application.Branch;

import java.util.List;

/**
 * Created by tsxuehu on 16/8/14.
 */
public interface BranchDao {
    Long save(Branch branch);

    void delete(String branchId);


    List<Branch> getProjectRelateBranch(Long id);
}
