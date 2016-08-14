package org.tsxuehu.pm.dao.impl;

import org.springframework.stereotype.Repository;
import org.tsxuehu.pm.dao.ShellDao;
import org.tsxuehu.pm.dao.dbobject.SCMDO;
import org.tsxuehu.pm.dao.dbobject.ShellDO;
import org.tsxuehu.pm.dao.dbobject.ShellDOExample;
import org.tsxuehu.pm.dao.mapper.ShellDOMapper;
import org.tsxuehu.pm.domain.build.Shell;
import org.tsxuehu.pm.domain.scm.SCM;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tsxuehu on 16/8/14.
 */
@Repository("shellDao")
public class ShellDaoImpl implements ShellDao {

    @Resource
    ShellDOMapper shellDOMapper;

    @Override
    public Long create(Shell shell) {
        ShellDO shellDO = convert(shell);
        shellDOMapper.insert(shellDO);
        return shellDO.getId();
    }

    @Override
    public void update(Shell shell) {
        ShellDO shellDO = convert(shell);
        shellDOMapper.updateByPrimaryKey(shellDO);
    }

    @Override
    public Shell getShell(Long id) {
        return convert(shellDOMapper.selectByPrimaryKey(id));
    }

    @Override
    public List<Shell> getShell(String type, String name,int pageNo,int pageSize) {
        ShellDOExample shellDOExample=new ShellDOExample();
        shellDOExample.setPageNo(pageNo);
        shellDOExample.setPageSize(pageSize);
        shellDOExample.createCriteria().andTypeEqualTo(type).andNameLike(name+"%");
        return convert( shellDOMapper.selectByExample(shellDOExample));
    }

    @Override
    public List<Shell> getAllShell() {
        ShellDOExample shellDOExample=new ShellDOExample();
        shellDOExample.setPageNo(1);
        shellDOExample.setPageSize(Integer.MAX_VALUE);
        return convert( shellDOMapper.selectByExample(shellDOExample));
    }

    private ShellDO convert(Shell shell) {
        ShellDO shellDO = new ShellDO();
        shellDO.setId(shell.getId());
        shellDO.setContent(shell.getContent());
        shellDO.setName(shell.getName());
        shellDO.setType(shell.getType());
        shellDO.setDescription(shell.getDescription());
        return shellDO;
    }
    private Shell convert(ShellDO shellDO){
        Shell shell =new Shell();
        shell.setId(shellDO.getId());
        shell.setName(shellDO.getName());
        shell.setType(shellDO.getType());
        shell.setDescription(shellDO.getDescription());
        shell.setContent(shellDO.getContent());
        return shell;
    }
    private List<Shell> convert(List<ShellDO> shellDOs){
        List<Shell> shells = new ArrayList<>(shellDOs.size());
        for (ShellDO shellDO : shellDOs) {
            shells.add(new Shell(shellDO.getId(),shellDO.getName(),shellDO.getDescription(),shellDO.getType()));
        }
        return shells;
    }
}
