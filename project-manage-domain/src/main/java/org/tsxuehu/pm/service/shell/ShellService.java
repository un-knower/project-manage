package org.tsxuehu.pm.service.shell;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.tsxuehu.pm.dao.ShellDao;
import org.tsxuehu.pm.domain.build.Shell;
import org.tsxuehu.pm.domain.build.ShellType;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tsxuehu on 16/8/12.
 */
@Service("shellService")
public class ShellService {
    @Resource
    ShellDao shellDao;
    /**
     * 选择一台编译机器执行shell脚本
     * 如果shell的content内容为空,执行
     * @param shell
     * @param param
     */
    public void excuteShell(Shell shell, String param) {
        //选择一台机器


        //检测脚本在机器上是否存在,若不存在则先上传脚本到机器



        //执行脚本



    }

    public Long createShell(String name,String description,String type,String content){
        return  shellDao.create(new Shell(null,name,description,type,content));
    }
    public void update(Long id,String name,String description,String type,String content){
        shellDao.update(new Shell(id,name,description,type,content));
    }

    public List<Shell> getAllShell(){
        return shellDao.getAllShell();
    }
    public Shell getShell(Long id){
        return shellDao.getShell(id);
    }
    /**
     * 返回匹配的5条记录
     * @param shellType
     * @param name
     * @return
     */
    public List<Shell> queryShell(String shellType,String name){
        return shellDao.getShell(shellType,name,1,5);
    }

    public ShellType[] getAllShellType(){
        return ShellType.getAllShellTypes();
    }
}
