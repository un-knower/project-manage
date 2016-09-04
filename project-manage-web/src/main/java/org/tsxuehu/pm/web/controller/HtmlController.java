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
public class HtmlController {


    @RequestMapping(value = "/{path}.html", method = RequestMethod.GET)
    public ModelAndView html(@PathVariable String path, HttpSession session) {


        Map<String, String> model = new HashMap<>();
        model.put("pageName",path);
        model.put("title",path);
        model.put("branch","daily/0.0.1");
        model.put("assets","http://rawgit.com/tsxuehu/project-manage-pages");

        return new ModelAndView("base", "model", model);
    }
}
