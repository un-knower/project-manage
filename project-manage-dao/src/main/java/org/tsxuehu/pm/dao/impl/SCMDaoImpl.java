package org.tsxuehu.pm.dao.impl;

import org.springframework.stereotype.Repository;
import org.tsxuehu.pm.dao.SCMDao;
import org.tsxuehu.pm.dao.dbobject.SCMDO;
import org.tsxuehu.pm.dao.dbobject.SCMDOExample;
import org.tsxuehu.pm.dao.mapper.SCMDOMapper;
import org.tsxuehu.pm.domain.scm.GitlabSCM;
import org.tsxuehu.pm.domain.scm.SCM;
import org.tsxuehu.pm.service.DomainFactoryRigistry;
import org.tsxuehu.pm.service.scm.SCMService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tsxuehu on 16/8/14.
 */
@Repository("scmDao")
public class SCMDaoImpl extends DomainFactoryRigistry implements SCMDao {
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
        scmdoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SCM getSCM(long id) {
        return convert(scmdoMapper.selectByPrimaryKey(id));
    }

    @Override
    public Long create(SCM scm) {
        SCMDO scmdo = new SCMDO();
        scmdo.setName(scm.getName());
        scmdo.setType(scm.getType());
        scmdo.setConfigure(scm.getConfigure());
        scmdoMapper.insert(scmdo);
        return scmdo.getId();
    }

    @Override
    public void update(SCM scm) {
        SCMDO scmdo = new SCMDO();
        scmdo.setId(scm.getId());
        scmdo.setName(scm.getName());
        scmdo.setType(scm.getType());
        scmdo.setConfigure(scm.getConfigure());
        scmdoMapper.updateByPrimaryKey(scmdo);
    }

    public List<SCM> convert(List<SCMDO> scmdos) {
        List<SCM> scms = new ArrayList<>(scmdos.size());
        for (SCMDO scmdo : scmdos) {
            scms.add(new SCM(scmdo.getId(), scmdo.getName(), scmdo.getType()));
        }
        return scms;
    }

    public SCM convert(SCMDO scmdo) {

        return (SCM) findFactory(SCMService.MODEL, scmdo.getType()).create(scmdo.getId(), scmdo.getName(), scmdo.getConfigure());


    }
}
