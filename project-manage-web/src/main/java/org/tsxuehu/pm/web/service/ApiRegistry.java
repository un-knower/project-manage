package org.tsxuehu.pm.web.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.tsxuehu.pm.domain.api.ApiDefinition;
import org.tsxuehu.pm.domain.api.Param;
import org.tsxuehu.pm.domain.api.ServiceParam;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tsxuehu on 16/7/3.
 */
@Service("apiRegistry")
public class ApiRegistry implements ApplicationContextAware {
    private  Map<String, ApiDefinition> apiRegistry;
    private ApplicationContext applicationContext;

    private  List<Param> getApiParams(JSONArray jsonArray) {
        return null;
    }

    private  List<ServiceParam> getServiceParams(JSONArray jsonArray) {

        List<ServiceParam> serviceParams = new ArrayList<>();
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            ServiceParam serviceParam = new ServiceParam();
            serviceParam.setName(jsonObject.getString("name"));
            serviceParam.setOrder(jsonObject.getInteger("order"));
            serviceParam.setType(jsonObject.getString("type"));
            serviceParam.setMapAPiParamName(jsonObject.getString("mapAPiParamName"));

            serviceParams.add(serviceParam);
        }
        return serviceParams;
    }
    @PostConstruct
    public void init() {
        InputStream in = ApiRegistry.class.getResourceAsStream("/api.json");
        InputStreamReader inReader = null;
        try {
            inReader = new InputStreamReader(in, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(inReader);
        String lineTxt = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while ((lineTxt = bufferedReader.readLine()) != null) {
                stringBuilder.append(lineTxt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        apiRegistry = new HashMap<>();
        JSONArray jsonArray = JSON.parseArray(stringBuilder.toString());
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            ApiDefinition api = new ApiDefinition();

            api.setKey(jsonObject.getString("key"));
            api.setVersion(jsonObject.getString("version"));

            api.setClassName(jsonObject.getString("className"));
            api.setMethod(jsonObject.getString("method"));

            //    api.setApiParams(getApiParams(jsonObject.getJSONArray("apiParams")));
            api.setServiceParams(getServiceParams(jsonObject.getJSONArray("serviceParams")));
            apiRegistry.put(api.getKey() + ":" + api.getVersion(), api);
        }
    }


    /**
     * @param apiKey
     * @param apiVersion
     */
    public  ApiDefinition getApiDefinition(String apiKey, String apiVersion) {
        return apiRegistry.get(apiKey + ":" + apiVersion);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    public ApplicationContext getApplicationContext(){
        return applicationContext;
    }
}
