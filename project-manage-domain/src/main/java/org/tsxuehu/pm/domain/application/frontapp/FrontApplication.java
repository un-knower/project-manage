package org.tsxuehu.pm.domain.application.frontapp;

import org.tsxuehu.pm.domain.application.Application;

/**
 * 前端工程
 * 包含cdn位置
 * 需要发布的页面
 * Created by tsxuehu on 16/7/23.
 */
public class FrontApplication extends Application {

    public static final String FRONT_PROJECT="front";
    public static String getType(){
        return FRONT_PROJECT;
    }
    public FrontApplication(String name,String url){

    }
}
