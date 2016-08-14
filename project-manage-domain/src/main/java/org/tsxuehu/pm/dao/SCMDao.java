package org.tsxuehu.pm.dao;

import org.tsxuehu.pm.domain.scm.SCM;

import java.util.List;

/**
 * Created by tsxuehu on 16/8/14.
 */
public interface SCMDao {
     List<SCM> getAllSCM();

     void deleteSCM(long id);

    SCM getSCM(long id);

    Long create(SCM scm);

    void update(SCM scm);
}
