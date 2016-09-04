package org.tsxuehu.midway.web.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by tsxuehu on 16/9/2.
 */
@Service("configure")
@Data
public class Configure {
    String repositoryType;//gitlab或者github
    String devRepositoryHost;//仓库地址
    String onlineRepositoryHost;//仓库地址
    String env;//仓库地址

    @PostConstruct
    public void init() throws URISyntaxException, FileNotFoundException {
        URL url = Registry.class.getResource("/configure.json");
        File file = new File(url.toURI());
        FileInputStream in = new FileInputStream(file);
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
        JSONObject jsonObject = JSON.parseObject(stringBuilder.toString());
        this.repositoryType = jsonObject.getString("repositoryType");
        this.devRepositoryHost = jsonObject.getString("devRepositoryHost");
        this.onlineRepositoryHost = jsonObject.getString("onlineRepositoryHost");
        this.env = jsonObject.getString("env");
    }
}
