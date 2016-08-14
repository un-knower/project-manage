package org.tsxuehu.pm.service.scm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.tsxuehu.pm.dao.SCMDao;
import org.tsxuehu.pm.domain.scm.SCM;
import org.tsxuehu.pm.service.DomainFactoryRigistry;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tsxuehu on 16/8/12.
 */
@Service("scmService")
public class SCMService extends DomainFactoryRigistry {
    public static final String MODEL="scm";

    @Resource
    SCMDao scmDao;

    public List<SCM> getAllSCM() {
        return scmDao.getAllSCM();
    }

    public void deleteSCM(long id) {
        scmDao.deleteSCM(id);
    }

    public Long create(String name,String type,String configure) {

        SCMFactory scmFactory = findFactory(MODEL,type);
        SCM scm = scmFactory.create(null,name,configure);
        return scmDao.create(scm);
    }

    public void update(Long id,String name,String type,String configure) {
        SCMFactory scmFactory = findFactory(MODEL,type);
        SCM scm = scmFactory.create(id,name,configure);
        scmDao.update(scm);
    }

    public SCM getSCM(Long id) {
        return scmDao.getSCM(id);
        //    return new GitlabSCM(null,"gitlab","2iAZn7fTUjKV9xsiS4KR","http://gitlab.qima-inc.com/");
    }

}
