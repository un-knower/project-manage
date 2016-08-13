package org.tsxuehu.pm.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by tsxuehu on 16/8/13.
 */
@Service("helloService")
public class HelloService {
    public String sayHello(String name,Integer time) {
        return name + "  你好 "+time+"次";
    }
}
