package org.tsxuehu.pm.service.scm;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.tsxuehu.pm.domain.scm.GitlabSCM;
import org.tsxuehu.pm.domain.scm.SCM;
import org.tsxuehu.pm.service.Factory;

/**
 * Created by tsxuehu on 16/8/14.
 */
@Component("scm-gitlab")
public class GitlabFactory implements SCMFactory {

    @Override
    public GitlabSCM create(Long id, String name, String configure) {
        return new GitlabSCM(id,name,configure);
    }
}
