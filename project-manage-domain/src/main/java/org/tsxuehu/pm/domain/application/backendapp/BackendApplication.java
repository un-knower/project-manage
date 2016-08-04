package org.tsxuehu.pm.domain.application.backendapp;

import org.tsxuehu.pm.domain.application.Application;
import org.tsxuehu.pm.domain.application.api.Api;

import java.util.List;

/**
 * 后端工程
 * 需要在前端暴露的接口
 * Created by tsxuehu on 16/7/23.
 */
public class BackendApplication extends Application {
    List<Api> apis;//应用包含的api
}
