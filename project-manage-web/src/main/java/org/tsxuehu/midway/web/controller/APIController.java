package org.tsxuehu.midway.web.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tsxuehu.midway.web.HttpCall;
import org.tsxuehu.midway.web.api.BackendService;
import org.tsxuehu.midway.web.api.HttpApi;
import org.tsxuehu.midway.web.service.Registry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.concurrent.Callable;

/**
 * Created by tsxuehu on 16/7/3.
 */
@Controller
public class APIController {
    @Resource
    Registry registry;

    @RequestMapping(value = "/api/{id}/{version}/{env}")
    @ResponseBody
    public Callable<String> api(@PathVariable final String id, @PathVariable final String version, @PathVariable final String env, final HttpServletRequest request, final HttpSession session) {


        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                HttpApi httpApi = registry.getHttpCall(id, version);

                BackendService service = registry.getService(httpApi.getServiceId());

                Result result = new Result();
                try {
                    /**
                     * 接口调用,可以监控接口的响应时间、失败次数、调用次数等数据 提供报警
                     */
                    result.setData(service.call(env, httpApi.getParamsMap(), new HttpCall(request, session),
                            registry.getApplicationContext()));

                    result.setSuccess(true);

                } catch (Exception e) {
                    result.setMsg("网络异常");
                }
                return JSON.toJSONString(result);
            }
        };
    }
}
