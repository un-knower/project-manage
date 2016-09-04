package org.tsxuehu.midway.web.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.tsxuehu.midway.web.HttpCall;
import org.tsxuehu.midway.web.api.BackendService;
import org.tsxuehu.midway.web.html.Html;
import org.tsxuehu.midway.web.html.InjectData;
import org.tsxuehu.midway.web.service.Registry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by tsxuehu on 16/7/3.
 */
@Controller
public class HtmlController {
    @Resource
    Registry registry;

    @RequestMapping(value = "/**/*.html", method = RequestMethod.GET)
    public Callable<ModelAndView> html(final HttpServletRequest request, final HttpSession session) {
        return new Callable<ModelAndView>() {

            @Override
            public ModelAndView call() throws Exception {
                String path = request.getRequestURI();
                if (StringUtils.isEmpty(path) || "/".equals(path)) {
                    path = "index.html";
                }

                HttpCall httpCall = new HttpCall(request, session);
                String env = httpCall.getString("env");

                Html html = registry.getHtml(path);
                if (html == null) {
                    return new ModelAndView("notfound");
                }
                try {
                    Map<String, Object> model = new HashMap<>();
                    model.put("cssFiles", html.getCssFiles());
                    model.put("jsFiles", html.getJsFiles());
                    model.put("title", html.getTitle());

                    JSONObject injectDateJSON = new JSONObject();
                    //todo 通过线程池并发获取页面数据
                    List<InjectData> injectDatas = html.getInjectDatas();
                    for (InjectData injectData : injectDatas) {
                        BackendService service = registry.getService(injectData.getServiceId());

                        Object callResult = service.call(env, injectData.getParamsMap(),
                                httpCall, registry.getApplicationContext());
                        injectDateJSON.put(injectData.getName(), callResult);
                    }
                    model.put("global", injectDateJSON.toJSONString());
                    return new ModelAndView("base", "model", model);
                }catch (Exception e){
                    return new ModelAndView("error");
                }

            }
        };
    }
}
