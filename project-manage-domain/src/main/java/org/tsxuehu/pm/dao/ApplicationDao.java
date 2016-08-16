package org.tsxuehu.pm.dao;

import org.tsxuehu.pm.domain.application.Application;

import java.util.List;

/**
 * Created by tsxuehu on 16/8/14.
 */
public interface ApplicationDao {
    Long create(Application application);

    void update(Application application);

    Application get(Long id);

    List<Application> getAllAplication();

}
