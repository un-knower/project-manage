package org.tsxuehu.midway.web;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 从http请求里获取参数
 * Created by tsxuehu on 16/8/28.
 */
public class HttpCall {

    HttpServletRequest request;
    HttpSession session;
    Map<String, String[]> maps;

    public HttpCall(HttpServletRequest request, HttpSession session) {

        this.request = request;
        this.session = session;
        maps = request.getParameterMap();
    }

    public String getValue(String key) {
        if (StringUtils.startsWith(key, "!")) {
            return getValueFromSession(StringUtils.substring(key, 1));
        } else {
            return getValueFromRequest(key);
        }
    }

    public String getValueFromRequest(String key) {
        String value = request.getParameter(key);
        if (value != null) {
            return value;
        }
        String[] mapValue = maps.get(key);
        if (mapValue != null && mapValue[0] != null)
            return mapValue[0];
        return null;
    }

    public String getValueFromSession(String key) {
        Object value = session.getAttribute(key);
        if (value != null) {
            return value.toString();
        }
        return null;
    }

    public String getString(String key) {
        return getValue(key);
    }

}
