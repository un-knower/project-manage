package org.tsxuehu.pm.service.scm;

import org.springframework.stereotype.Service;
import org.tsxuehu.pm.dao.SCMDao;
import org.tsxuehu.pm.domain.scm.GitlabSCM;
import org.tsxuehu.pm.domain.scm.SCM;

import java.util.List;

/**
 * Created by tsxuehu on 16/8/12.
 */
@Service("scmService")
public class SCMService {
    SCMDao scmDao;
    public List<SCM> getAllSCM(){
        return scmDao.getAllSCM();
    }
    public void deleteSCM(long id){
         scmDao.deleteSCM(id);
    }

    public SCM getSCM(long scmId){

        return new GitlabSCM(null,"gitlab","2iAZn7fTUjKV9xsiS4KR","http://gitlab.qima-inc.com/");
    }
}
