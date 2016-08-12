package org.tsxuehu.pm.service.scm;

import org.tsxuehu.pm.domain.scm.GitSCM;
import org.tsxuehu.pm.domain.scm.SCM;

/**
 * Created by tsxuehu on 16/8/12.
 */
public class SCMService {
    public SCM getSCM(long scmId){
        return new GitSCM(null,"gitlab","2iAZn7fTUjKV9xsiS4KR","http://gitlab.qima-inc.com/");
    }
}
