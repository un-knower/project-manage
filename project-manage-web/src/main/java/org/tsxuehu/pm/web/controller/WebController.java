package org.tsxuehu.pm.web.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.tsxuehu.pm.domain.api.ApiDefinition;
import org.tsxuehu.pm.web.service.ApiRegistry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tsxuehu on 16/7/3.
 */
@Controller
public class WebController {
    @Resource
    ApiRegistry apiService;

    @RequestMapping(value = "/api/{apikey}/{version}/call")
    @ResponseBody
    public String api(@PathVariable String apikey, @PathVariable String version, HttpServletRequest request, HttpSession session) {

        ApiDefinition apiDefinition = apiService.getApiDefinition(apikey, version);

        Map<String, String[]> maps = request.getParameterMap();

        Map<String, String> params = new HashMap<>();

        String[] paramsNames = apiDefinition.getParamsName();
        for (String paramsName : paramsNames) {
            params.put(paramsName, getValue(paramsName, request, session, maps));
        }

        Result result = new Result();
        try {
            /**
             * 接口调用,可以监控接口的响应时间、失败次数、调用次数等数据 提供报警
             */
            result.setData(apiDefinition.call(params, apiService.getApplicationContext()));

            result.setCallSuccess(true);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = {"/*", "/index"}, method = RequestMethod.GET)
    public ModelAndView html(HttpServletRequest request, HttpSession session) {
        Map<String, String> user = new HashMap<>();
        user.put("name", request.getRequestURI());

        return new ModelAndView("helloworld", "user", user);
    }

    public String getValue(String paramName, HttpServletRequest request, HttpSession session, Map<String, String[]> maps) {
        String value = request.getParameter(paramName);
        if (value != null) {
            return value;
        }
        String[] mapValue = maps.get(paramName);
        if (mapValue != null && mapValue[0] != null)
            return mapValue[0];
        return null;
    }
}
