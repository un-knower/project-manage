package org.tsxuehu.pm.domain.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.Data;

import java.util.List;

/**
 * Created by tsxuehu on 16/7/23.
 */
@Data
public class User {
    public static User userFromJSONString(String jsonStr) {
        return JSON.parseObject(jsonStr, User.class);
    }

    public static List<User> userListFromJSONString(String jsonStr) {
        return JSON.parseArray(jsonStr, User.class);
    }

    public static String toJSONString(List<User> users) {
        if(users==null)
            return null;
        return JSONArray.toJSONString(users);
    }

    public User() {
    }

    Long id;
    String name;

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toJSONString() {
        return JSON.toJSONString(this);
    }
}
