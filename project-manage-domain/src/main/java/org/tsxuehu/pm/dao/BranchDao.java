package org.tsxuehu.pm.dao;

import org.tsxuehu.pm.domain.application.Branch;

import java.util.List;

/**
 * Created by tsxuehu on 16/8/14.
 */
public interface BranchDao {
    Long create(Branch branch);

    void delete(Long branchId);


    List<Branch> getProjectRelateBranch(Long id);

    Branch getBranch(Long branchId);

    List<Branch> getBranchList(List<Long> branchIds);
}
