package org.tsxuehu.pm.dao;

import org.tsxuehu.pm.domain.build.Machine;

import java.util.List;

/**
 * Created by tsxuehu on 16/8/15.
 */
public interface MachineDao {
    List<Machine> getAll();

    Machine get(Long id);

    void update(Machine machine);

    Long create(Machine machine);
}
