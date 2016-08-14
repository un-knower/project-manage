package org.tsxuehu.pm.domain.scm;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Data;

import java.io.IOException;

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

    public String createNewBranch(String projectId, String newBranchName, String fromBranch) throws IOException {
        return null;
    }

    @JSONField(serialize=false)
    public String getConfigure() {
        return "";
    }
}
