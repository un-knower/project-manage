package org.tsxuehu.pm.dao.impl;

import org.springframework.stereotype.Repository;
import org.tsxuehu.pm.dao.ApplicationDao;
import org.tsxuehu.pm.dao.dbobject.ApplicationDO;
import org.tsxuehu.pm.dao.dbobject.ApplicationDOExample;
import org.tsxuehu.pm.dao.mapper.ApplicationDOMapper;
import org.tsxuehu.pm.domain.application.Application;
import org.tsxuehu.pm.domain.application.Server;
import org.tsxuehu.pm.domain.user.User;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tsxuehu on 16/8/16.
 */
@Repository("applicationDao")
public class ApplicationDaoImpl implements ApplicationDao {

    @Resource
    ApplicationDOMapper applicationDOMapper;

    @Override
    public Long create(Application application) {
        ApplicationDO applicationDO = convert(application);
        applicationDOMapper.insert(applicationDO);
        return applicationDO.getId();
    }

    @Override
    public void update(Application application) {
        applicationDOMapper.updateByPrimaryKeySelective(convert(application));
    }

    @Override
    public Application get(Long id) {
        return convert(applicationDOMapper.selectByPrimaryKey(id));
    }

    @Override
    public List<Application> getAllAplication() {
        ApplicationDOExample example = new ApplicationDOExample();

        return convert(applicationDOMapper.selectByExample(example));
    }

    private ApplicationDO convert(Application application) {
        ApplicationDO applicationDO = new ApplicationDO();
        applicationDO.setId(application.getId());
        applicationDO.setName(application.getName());
        applicationDO.setDescription(application.getDescription());
        applicationDO.setScmId(application.getScmId());
        applicationDO.setGitlabProjectId(application.getGitlabProjectId());
        applicationDO.setDailyMachines(
                Server.toJSONString(application.getDailyMachines())
        );
        applicationDO.setPreMachines(
                Server.toJSONString(application.getPreMachines())
        );
        applicationDO.setFormalMachines(
                Server.toJSONString(application.getFormalMachines())
        );
        applicationDO.setPublishers(
                User.toJSONString(application.getPublishers())
        );

        applicationDO.setMergeshellid(application.getMergeShellId());
        applicationDO.setBuildshellid(application.getBuildShellId());
        applicationDO.setPublishshellid(application.getPublishShellId());

        applicationDO.setReview(application.getReviewJSONString());
        applicationDO.setAppParam(application.getAppParam());

        applicationDO.setOwner(application.getOwner() == null ? null : application.getOwner().toJSONString());

        return applicationDO;
    }

    private Application convert(ApplicationDO applicationDO) {
        return Application.create(applicationDO.getId(), applicationDO.getName(),
                applicationDO.getDescription(), applicationDO.getScmId(),
                applicationDO.getGitlabProjectId(), applicationDO.getDailyMachines(),
                applicationDO.getPreMachines(), applicationDO.getFormalMachines(),
                applicationDO.getPublishers(), applicationDO.getMergeshellid(),
                applicationDO.getBuildshellid(), applicationDO.getPublishshellid(),
                applicationDO.getReview(), applicationDO.getAppParam(), applicationDO.getOwner());
    }

    private List<Application> convert(List<ApplicationDO> applicationDOs) {
        List<Application> applications = new ArrayList<>(applicationDOs.size());
        for (ApplicationDO applicationDO : applicationDOs) {
            applications.add(new Application(applicationDO.getId(), applicationDO.getName(), applicationDO.getDescription(),
                    User.userFromJSONString(applicationDO.getOwner())));
        }
        return applications;
    }
}
