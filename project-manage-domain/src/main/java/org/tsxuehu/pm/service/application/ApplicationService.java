package org.tsxuehu.pm.service.application;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.tsxuehu.pm.dao.ApplicationDao;
import org.tsxuehu.pm.domain.application.Application;
import org.tsxuehu.pm.domain.application.Server;
import org.tsxuehu.pm.domain.user.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tsxuehu on 16/8/12.
 */
@Service("applicationService")
public class ApplicationService {
    @Resource
    ApplicationDao applicationDao;

    /**
     * 创建应用分为两步
     * 1、用户创建基础信息
     * 2、运维更新scm、构建脚本信息
     *
     * @param name
     * @param
     * @param creatorName
     */
    Long createApplication(String name, String description, Long creatorId, String creatorName) {
        return applicationDao.create(new Application(null, name, description, new User(creatorId, creatorName)));
    }

    void updateApplication(Long id, String description, Long scmId, String gitlabProjectId,
                           String dailyMachines, String preMachines, String formalMachines,
                           String publishers, Long mergeShellId, Long buildShellId, Long pushShellId,
                           String review, String appParam) {
        applicationDao.update(Application.create(id, null, description, scmId, gitlabProjectId, dailyMachines, preMachines,
                formalMachines, publishers, mergeShellId, buildShellId, pushShellId, review, appParam, null));
    }

    /**
     * 获取一个应用详细信息
     *
     * @param id
     * @return
     */
    public Application getApplication(Long id) {
        return applicationDao.get(id);
    }

    public List<Application> getAllAplication() {
        return applicationDao.getAllAplication();

    }
}
