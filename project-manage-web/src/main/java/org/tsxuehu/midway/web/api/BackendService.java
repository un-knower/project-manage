package org.tsxuehu.midway.web.api;

import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.tsxuehu.midway.web.HttpCall;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * service、function、version唯一确定一个服务
 * 后端服务
 * Created by tsxuehu on 16/8/28.
 */
@Data
public class BackendService implements Idable {
    String type;
    String service;
    String function;
    String version;
    Parameter[] parameters;

    /**
     * @param env 服务所在环境
     * @param paramsMap 服务参数和请求参数的映射
     * @param httpCall 请求封装对象,从请求中获取参数值
     * @param applicationContext spring上下文
     * @return
     */
    public Object call(String env, Map<String, String> paramsMap, HttpCall httpCall, ApplicationContext applicationContext) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        throw new NotImplementedException();
    }

    @Override
    public String getId() {
        return service+"."+function+":"+version;
    }
}
