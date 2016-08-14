package org.tsxuehu.pm.service.application;

import org.springframework.stereotype.Service;
import org.tsxuehu.pm.domain.application.Application;
import org.tsxuehu.pm.domain.user.User;

import java.util.List;

/**
 * Created by tsxuehu on 16/8/12.
 */
@Service("applicationService")
public class ApplicationService {
    /**
     * 创建应用分为两步
     * 1、用户创建基础信息
     * 2、运维更新scm、构建脚本信息
     * @param name
     * @param
     * @param creatorName
     */
    Long createApplication(String name, String description, String creatorId,String  creatorName){
        return null;
    }
    void updateApplication(){

    }
    /**
     * 获取用户user创建的所有引用
     *
     * @param user
     * @return
     */
    List<Application> getApplication(User user, int pageNo, int pageSize){
        return null;
    }




    /**
     * 获取一个应用详细信息
     *
     * @param appName
     * @return
     */
    public Application getApplication(String appName){
        return null;
    }

}
