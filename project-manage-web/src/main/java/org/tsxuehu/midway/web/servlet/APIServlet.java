package org.tsxuehu.midway.web.servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 没有使用
 * Created by tsxuehu on 16/9/1.
 */
public class APIServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext ac  = WebApplicationContextUtils.getRequiredWebApplicationContext(
                req.getServletContext()

        );
    }
}
