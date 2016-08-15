package org.tsxuehu.pm.domain.application;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.Data;

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
        if(servers==null)
            return null;
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
