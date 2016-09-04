package org.tsxuehu.midway.web.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.tsxuehu.midway.web.api.BackendService;
import org.tsxuehu.midway.web.api.Idable;
import org.tsxuehu.midway.web.html.Html;
import org.tsxuehu.midway.web.api.HttpApi;
import org.tsxuehu.midway.web.api.SpringService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tsxuehu on 16/7/3.
 */
@Service("registry")
public class Registry implements ApplicationContextAware {
    @Resource
    Configure configure;
    private Map<String, HttpApi> httpCallMap = new HashMap<>();
    private Map<String, BackendService> serviceMap = new HashMap<>();
    private Map<String, Html> htmlMap = new HashMap<>();
    private ApplicationContext applicationContext;

    /**
     * 加载接口配置文件
     * 分别加载spring、dubbo、hsf(不同类型的接口定义文件存放于不同的文件夹下面)
     *
     * @throws URISyntaxException
     * @throws FileNotFoundException
     */
    @PostConstruct
    public void init() throws URISyntaxException, FileNotFoundException {
        regist(httpCallMap, "/httpapi", HttpApi.class);
        regist(serviceMap, "/service/spring", SpringService.class);
        //     regist(serviceMap, "service/dubbo", SpringService.class);
        //注册html
        regist(htmlMap, "/html", Html.class);
        for (Map.Entry<String, Html> stringHtmlEntry : htmlMap.entrySet()) {
            stringHtmlEntry.getValue().calculateStaticResouceLocation(configure);
        }
    }

    public <O extends Idable, T extends Idable> void regist(Map<String, O> respository, String dir, Class<T> clazz) throws URISyntaxException, FileNotFoundException {

        //枚举要注册的文件
        URL url = Registry.class.getResource(dir);
        File file = new File(url.toURI());
        File[] jsonFiles = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".json");
            }
        });
        //对每个文件解析 注册
        for (File jsonFile : jsonFiles) {
            List<T> objs = parseJSONFile(jsonFile, clazz);
            for (T obj : objs) {
                respository.put(obj.getId(), (O) obj);
            }
        }

    }

    private <T extends Idable> List<T> parseJSONFile(File filename, Class<T> clazz) throws FileNotFoundException {
        FileInputStream in = new FileInputStream(filename);
        InputStreamReader inReader = null;
        try {
            inReader = new InputStreamReader(in, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(inReader);
        String lineTxt;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while ((lineTxt = bufferedReader.readLine()) != null) {
                stringBuilder.append(lineTxt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JSON.parseArray(stringBuilder.toString(), clazz);
    }


    /**
     * @param id
     * @param version
     */
    public HttpApi getHttpCall(String id, String version) {
        return httpCallMap.get(id + ":" + version);
    }

    public BackendService getService(String id) {
        return serviceMap.get(id);
    }

    public Html getHtml(String path) {
        return htmlMap.get(path);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
