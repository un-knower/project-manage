package org.tsxuehu.pm.domain.application;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.tsxuehu.pm.domain.user.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tsxuehu on 16/8/12.
 */
@Data
public class Server {
    public static Server serverFromJSONString(String jsonStr){
        return  JSON.parseObject(jsonStr,Server.class);
    }
    public static List<Server> serverListFromJSONString(String jsonStr){
        return  JSON.parseArray(jsonStr,Server.class);
    }
    public static String toJSONString(List<Server> servers){
        return JSONArray.toJSONString(servers);
    }

    String name;
    String location;

    public Server() {
    }

    public Server(String name, String location) {
        this.name = name;
        this.location = location;
    }
    public String toJSONString(){
       return JSON.toJSONString(this);
    }

}
