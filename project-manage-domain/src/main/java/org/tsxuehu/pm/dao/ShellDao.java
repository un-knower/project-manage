package org.tsxuehu.pm.dao;

import org.tsxuehu.pm.domain.build.Shell;

import java.util.List;

/**
 * Created by tsxuehu on 16/8/14.
 */
public interface ShellDao {
    Long create(Shell shell);

    void update(Shell shell);

    Shell getShell(Long id);
    List<Shell> getShell(String type,String name,int pageNo,int pageSize);

    List<Shell> getAllShell();
}
