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
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tsxuehu on 16/7/3.
 */
@Service("apiRegistry")
public class ApiRegistry implements ApplicationContextAware {
    private  Map<String, ApiDefinition> apiRegistry = new HashMap<>();;
    private ApplicationContext applicationContext;


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
    public void init() throws URISyntaxException, FileNotFoundException {
       URL url = ApiRegistry.class.getResource("/api");
        File file =new File(url.toURI());
        String[] jsonFiles = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".json");
            }
        });

        for (String jsonFile : jsonFiles) {
            parseJSONFile(jsonFile);
        }


    }

    private void parseJSONFile(String filename) throws FileNotFoundException {
        FileInputStream in = new FileInputStream(filename);
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
