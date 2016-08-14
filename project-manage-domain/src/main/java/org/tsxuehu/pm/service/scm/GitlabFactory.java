package org.tsxuehu.pm.service.scm;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.tsxuehu.pm.domain.scm.GitlabSCM;
import org.tsxuehu.pm.service.Factory;

/**
 * Created by tsxuehu on 16/8/14.
 */
@Component("scm-gitlab")
public class GitlabFactory implements Factory {
    @Override
    public GitlabSCM create(JSONObject jsonObject) {
        return GitlabSCM.create(jsonObject);
    }
}
