package org.tsxuehu.pm.dao.impl;

import org.springframework.stereotype.Repository;
import org.tsxuehu.pm.dao.MachineDao;
import org.tsxuehu.pm.dao.dbobject.MachineDO;
import org.tsxuehu.pm.dao.dbobject.MachineDOExample;
import org.tsxuehu.pm.dao.mapper.MachineDOMapper;
import org.tsxuehu.pm.domain.build.Machine;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tsxuehu on 16/8/15.
 */
@Repository("machineDao")
public class MachineDaoImpl implements MachineDao {
    @Resource
    MachineDOMapper machineDOMapper;

    @Override
    public List<Machine> getAll() {
        MachineDOExample example = new MachineDOExample();
        return convert(machineDOMapper.selectByExample(example));
    }

    @Override
    public Machine get(Long id) {
        return convert(machineDOMapper.selectByPrimaryKey(id));
    }

    @Override
    public void update(Machine machine) {
        machineDOMapper.updateByPrimaryKey(convert(machine));
    }

    @Override
    public Long create(Machine machine) {
        MachineDO machineDO = convert(machine);
        machineDOMapper.insert(machineDO);
        return machineDO.getId();
    }

    private Machine convert(MachineDO machineDO) {
        return new Machine(machineDO.getId(), machineDO.getName(), machineDO.getLocation(), machineDO.getPort(),
                machineDO.getUsername(), machineDO.getPassword());
    }

    private MachineDO convert(Machine machine) {
        MachineDO machineDO = new MachineDO();
        machineDO.setId(machine.getId());
        machineDO.setName(machine.getName());
        machineDO.setLocation(machine.getLocation());
        machineDO.setPort(machine.getPort());
        machineDO.setUsername(machine.getUsername());
        machineDO.setPassword(machine.getPassword());
        return machineDO;
    }

    private List<Machine> convert(List<MachineDO> machineDOs) {
        List<Machine> machines = new ArrayList<>(machineDOs.size());
        for (MachineDO machineDO : machineDOs) {
            machines.add(new Machine(machineDO.getId(), machineDO.getName(), machineDO.getLocation(), machineDO.getPort(),
                    machineDO.getUsername(), machineDO.getPassword()));
        }
        return machines;
    }

}
