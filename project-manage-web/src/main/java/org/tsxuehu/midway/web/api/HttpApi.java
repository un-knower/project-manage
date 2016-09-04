package org.tsxuehu.midway.web.api;

import lombok.Data;

import java.util.Map;

/**
 * http接口定义
 * id、version唯一确定一个接口
 * 对外暴露的api接口
 * Created by tsxuehu on 16/8/28.
 */
@Data
public class HttpApi implements Idable {
    String name;
    String version;
    String serviceId;
    Map<String, String> paramsMap;


    public Map<String, String> getParamsMap() {
        return paramsMap;
    }

   /* public void setParamsMap(Map<String, String> paramsMapHttpapi2Service) {
        this.paramsMap = new HashMap<>(paramsMapHttpapi2Service.size());
        for (Map.Entry<String, String> stringStringEntry : paramsMapHttpapi2Service.entrySet()) {
            this.paramsMap.put(stringStringEntry.getValue(), stringStringEntry.getKey());
        }
    }*/

    /**
     * 服务和http请求之间的参数映射
     */
    @Override
    public String getId() {
        return name + ":" + version;
    }
}
