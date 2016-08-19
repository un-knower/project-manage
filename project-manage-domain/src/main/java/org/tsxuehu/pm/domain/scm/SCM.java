package org.tsxuehu.pm.domain.scm;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Data;
import org.tsxuehu.pm.domain.application.Branch;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by tsxuehu on 16/8/12.
 */
@Data
public class SCM {
    public SCM(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    Long id;
    String name;
    String type;

    public String createNewBranch(String scmProjectId, String newBranchName, String fromBranch) throws IOException {
        return null;
    }

    /**
     * 获取分支最新的提交commit
     * @param projectSCMId
     * @param branchName
     * @return
     */
    @JSONField(serialize=false)
    public String getBranchNewestPoint(String projectSCMId,String branchName) throws IOException {
        return null;
    }
    @JSONField(serialize=false)
    public String getConfigure() {
        return "";
    }

    public String getRepositoryLocation(String gitlabProjectId) {
        return null;
    }
}
