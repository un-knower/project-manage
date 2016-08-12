package org.tsxuehu.pm.service.application;

import org.tsxuehu.pm.domain.application.Application;
import org.tsxuehu.pm.domain.user.User;

import java.util.List;

/**
 * Created by tsxuehu on 16/8/12.
 */
public interface ApplicationService {
    /**
     * 通过子类构造创建
     *
     * @param name
     * @param
     * @param creator
     */
    void createApplication(String name, String description, User creator);

    /**
     * 获取用户user创建的所有引用
     *
     * @param user
     * @return
     */
    List<Application> getApplication(User user, int pageNo, int pageSize);




    /**
     * 获取一个应用详细信息
     *
     * @param appName
     * @return
     */
    public Application getApplication(String appName);

}
