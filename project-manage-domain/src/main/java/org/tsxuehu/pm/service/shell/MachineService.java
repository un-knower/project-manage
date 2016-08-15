package org.tsxuehu.pm.service.shell;

import org.springframework.stereotype.Service;
import org.tsxuehu.pm.dao.MachineDao;
import org.tsxuehu.pm.domain.build.Machine;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tsxuehu on 16/8/12.
 */
@Service("machineService")
public class MachineService {
    @Resource
    MachineDao machineDao;
    public Long create(String name,String location,String port,String username,String password){
        return  machineDao.create(name,location,port,username,password);
    }
    public  void update(Long id,String name,String location,String port,String username,String password){
          machineDao.update(id,name,location,port,username,password);
    }
    public Machine get(Long id){
        return  machineDao.get(id);
    }
    public List<Machine> getAllMachine(){
        return  machineDao.getAll();
    }
}
