package org.tsxuehu.pm.dao;

import org.tsxuehu.pm.domain.build.Machine;

import java.util.List;

/**
 * Created by tsxuehu on 16/8/15.
 */
public interface MachineDao {
    List<Machine> getAll();

    Machine get(Long id);

    void update(Long id, String name, String location, String port, String username, String password);

    Long create(String name, String location, String port, String username, String password);
}
