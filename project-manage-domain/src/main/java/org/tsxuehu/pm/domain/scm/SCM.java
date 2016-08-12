package org.tsxuehu.pm.domain.scm;

import java.io.IOException;

/**
 * Created by tsxuehu on 16/8/12.
 */
public interface SCM {
    String createNewBranch(String projectId, String newBranchName, String fromBranch) throws IOException;
}
