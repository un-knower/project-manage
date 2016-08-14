package org.tsxuehu.pm.domain.scm;

import java.io.IOException;

/**
 * Created by tsxuehu on 16/8/12.
 */
public class SCM {
    public SCM(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    Long id;
    String name;
    String type;

    public String createNewBranch(String projectId, String newBranchName, String fromBranch) throws IOException {
        return null;
    }

}
