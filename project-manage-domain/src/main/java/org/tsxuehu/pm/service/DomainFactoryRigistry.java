package org.tsxuehu.pm.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.tsxuehu.pm.service.scm.SCMFactory;

/**
 * Created by tsxuehu on 16/8/14.
 */
public class DomainFactoryRigistry implements ApplicationContextAware {
    protected ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public <T extends Factory> T findFactory(String module, String type) {
        return (T)applicationContext.getBean(module+"-"+type);
    }
}
