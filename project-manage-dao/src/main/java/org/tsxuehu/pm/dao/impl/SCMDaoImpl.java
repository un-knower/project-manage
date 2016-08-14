package org.tsxuehu.pm.dao.impl;

import org.springframework.stereotype.Service;
import org.tsxuehu.pm.dao.SCMDao;
import org.tsxuehu.pm.dao.dbobject.SCMDO;
import org.tsxuehu.pm.dao.dbobject.SCMDOExample;
import org.tsxuehu.pm.dao.mapper.SCMDOMapper;
import org.tsxuehu.pm.domain.scm.GitlabSCM;
import org.tsxuehu.pm.domain.scm.SCM;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tsxuehu on 16/8/14.
 */
@Service("scmDao")
public class SCMDaoImpl implements SCMDao {
    @Resource
    SCMDOMapper scmdoMapper;

    @Override
    public List<SCM> getAllSCM() {
        SCMDOExample example = new SCMDOExample();
        List<SCMDO> scmdos = scmdoMapper.selectByExample(example);
        return convert(scmdos);
    }

    @Override
    public void deleteSCM(long id) {

    }

    public List<SCM> convert(List<SCMDO> scmdos) {
        List<SCM> scms = new ArrayList<>(scmdos.size());
        for (SCMDO scmdo : scmdos) {
            scms.add(new SCM(scmdo.getId(), scmdo.getName(), scmdo.getConfigure()));
        }
        return scms;
    }

    public SCM convert(SCMDO scmdo) {
        if("gitlab".equals(scmdo.getType())){
            return  new GitlabSCM(scmdo.getId(), scmdo.getName(), scmdo.getType());
        }
        return null;

    }
}
